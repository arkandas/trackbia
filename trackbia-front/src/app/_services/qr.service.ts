import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {QRCode} from "../models/QRCode";
import {environment} from "../../environments/environment";
import {UserView} from "../models/UserView";
import {DeviceDetectorService} from "ngx-device-detector";

const AUTH_API = environment.apiUrl + '/api/qr/';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class QrService {

  constructor(private http: HttpClient, private deviceService: DeviceDetectorService) {
  }

  createQrCode(QRCode: QRCode): Observable<any> {
    return this.http.post(AUTH_API + 'createqr', QRCode, httpOptions);
  }

  updateQrCode(hashId: string, codeDescription: string) {
    return this.http.post(AUTH_API + 'update/' + hashId, codeDescription, httpOptions);

  }


  deleteQrByHashId(hashId: string) {
    return this.http.post(AUTH_API + 'delete/' + hashId, httpOptions);
  }

  createQrView(page: string, hashId: string) {
    let pageView = new UserView(
      page,
      this.deviceService.getDeviceInfo().browser,
      this.deviceService.getDeviceInfo().browser_version,
      this.deviceService.getDeviceInfo().device,
      this.deviceService.getDeviceInfo().deviceType,
      this.deviceService.getDeviceInfo().os,
      this.deviceService.getDeviceInfo().os_version,
      hashId
    );

    return this.http.post(AUTH_API + 'qrview', pageView, httpOptions);
  }


}
