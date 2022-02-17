import {Component, OnInit} from '@angular/core';
import {AuthService} from "../_services/auth.service";
import {QrService} from "../_services/qr.service";
import {QRCode} from "../models/QRCode";
import * as CryptoJS from 'crypto-js';
import {
  faRedo,
  faDownload,
  faCheckCircle,
  faWindowClose,
  faExternalLinkAlt,
  faEdit
} from "@fortawesome/free-solid-svg-icons";
import {PageService} from "../_services/page.service";
import {first} from "rxjs/operators";
import {environment} from "../../environments/environment";
import {PaginationService} from "../_services/pagination.service";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  redoIcon = faRedo;
  downloadIcon = faDownload;
  checkCircleIcon = faCheckCircle;
  externalLinkIcon = faExternalLinkAlt;
  editQrIcon = faEdit;
  windowCloseIcon = faWindowClose;

  public version: string = environment.version;
  viewInfo: any;

  p: number = 1;
  qrInfo: any[] = [];

  successNotification = false;

  public isVisible: boolean = false;
  disableTextArea = false;
  isQrCreated = false;
  isQrEdited = false;
  errorMessage = '';
  qrHashId = this.createNewQrHashId();
  responseMessage = ''

  form: any = {
    hashId: this.qrHashId,
    codeDescription: null,
  };

  ngOnInit(): void {
    this.loadQrViews();
    setInterval(() => {
      this.loadQrViews()
    }, 5000);
  }

  public qrCodeVal: string = '';
  public level: "L" | "M" | "Q" | "H";
  public width: number;
  hashIdEnabled: boolean = false;

  constructor(private qrService: QrService, private PageService: PageService, private paginationService: PaginationService,) {
    this.level = "H";
    this.qrCodeVal = 'https://trackbia.arkandas.com/home/' + this.qrHashId;
    this.width = 1000;
  }

  createNewQrHashId() {
    const myQrId = CryptoJS.SHA1(new Date().toISOString()).toString();
    return myQrId.slice(-14);
  }

  // Pagination object
  pagination: any = {};

  // Paged items
  pagedItems: any[] = [];

  setPage(page: number) {
    if (page < 1 || page > this.pagination.totalPages) {
      return;
    }
    // Get pagination object from service
    this.pagination = this.paginationService.getPagination(this.qrInfo.length, page, 14);
    // Get current page of items
    this.pagedItems = this.qrInfo.slice(this.pagination.startIndex, this.pagination.endIndex + 1);
  }


  onSubmit(): void {
    const {hashId, codeDescription} = this.form;
    let myQrCode = new QRCode(0, hashId, codeDescription, "https://trackbia.arkandas.com/home/" + hashId, new Date().toISOString(), 0, 1,);

    this.qrService.createQrCode(myQrCode).subscribe(
      data => {
        this.disableTextArea = true;
        this.successNotification = true;
        this.responseMessage = 'QR created successfully';
        this.isVisible = true;
        this.isQrCreated = true;
        setTimeout(() => this.loadQrViews(), 1500); // hide the alert after 2.5s
      },
      err => {
        this.responseMessage = 'Error during QR creation';

        this.errorMessage = err.error.message;
        this.errorMessage = err.message;
        this.isVisible = true;
        setTimeout(() => this.loadQrViews(), 1500); // hide the alert after 2.5s
        this.loadQrViews();
      }
    );
  }

  public downloadQRCode() {
    const fileNameToDownload = 'qrcode_' + this.form.hashId;
    // @ts-ignore
    const base64Img = document.getElementById('mycanvas').children[0]['src'];
    fetch(base64Img)
      .then(res => res.blob())
      .then((blob) => {
        // IE
        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
          window.navigator.msSaveOrOpenBlob(blob, fileNameToDownload);
        } else { // Chrome
          const url = window.URL.createObjectURL(blob);
          const link = document.createElement('a');
          link.href = url;
          link.download = fileNameToDownload;
          link.click();
        }
      })
  }


  private loadQrViews() {
    console.log("Qr Qrray: " + this.qrInfo);
    this.isVisible = false;
    this.PageService.getQrViews()
      .pipe(first())
      .subscribe(qrViews => {
        this.qrInfo = [];
        this.pagedItems = [];
        this.pagination = {};
        this.qrInfo = qrViews.qrInfo;
        this.viewInfo = qrViews.viewInfo;
        this.setPage(1);
      });
  }

  public deleteQrCodeByHashId(hashId: string) {
    this.qrService.deleteQrByHashId(hashId)
      .pipe(first())
      .subscribe(qrViews => {
        // this.isQrCreated = false;
        this.successNotification = false;
        this.responseMessage = 'QR deleted successfully';
        this.isVisible = true;
        setTimeout(() => this.loadQrViews(), 500);
      });
  }

  editQrCodeByHashId(qrCode: any) {
    this.form.hashId = qrCode.hashId;
    this.qrCodeVal = 'https://trackbia.arkandas.com/' + this.form.hashId;
    this.form.codeDescription = qrCode.description;
    this.isQrCreated = true;
    this.isQrEdited = true;
  }

  editQrCode() {
    this.qrService.updateQrCode(this.form.hashId, this.form.codeDescription).subscribe(
      data => {
        this.disableTextArea = true;
        this.successNotification = true;
        this.responseMessage = 'QR edited successfully';
        this.isVisible = true;
        this.resetQRCreation();
        setTimeout(() => this.loadQrViews(), 1500); // hide the alert after 2.5s
      },
      err => {
        this.responseMessage = 'Error during QR edition';
        this.errorMessage = err.error.message;
        this.errorMessage = err.message;
        this.isVisible = true;
        this.resetQRCreation();
        setTimeout(() => this.loadQrViews(), 1500); // hide the alert after 2.5s
      }
    );
  }

  public resetQRCreation() {
    this.form.hashId = this.createNewQrHashId();
    this.qrCodeVal = 'https://trackbia.arkandas.com/' + this.form.hashId;
    this.form.codeDescription = '';
    this.disableTextArea = false;
    this.isQrEdited = false;
    this.isQrCreated = false;
  }

}
