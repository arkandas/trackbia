import {Component, Input, OnInit} from '@angular/core';
import {PaginationService} from "../_services/pagination.service";
import {Subscription} from "rxjs";
import {first} from "rxjs/operators";
import {SharedService} from "../_services/shared.service";
import {ViewsBackendService} from "../_services/views-backend.service";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-view-card-list',
  templateUrl: './view-card-list.component.html',
  styleUrls: ['./view-card-list.component.scss']
})
export class ViewCardListComponent implements OnInit {
  public version: string = environment.version;
  clickEventSubscription: Subscription;
  p: number = 1;
  viewsByIps: any[] = [];

  constructor(private paginationService: PaginationService,
              private ViewsbackendService: ViewsBackendService,
              private sharedService: SharedService) {

    this.clickEventSubscription = this.sharedService.getClickEvent().subscribe(() => {
      // console.log('View Card Component -> Reload View Card Component');
      this.loadLastViews();
    });
  }

  @Input()
  hashId!: string;

  // Pagination object
  pagination: any = {};

  // Paged items
  pagedItems: any[] | undefined;

  ngOnInit(): void {
    this.loadLastViews();
    setInterval(() => {
      this.loadLastViews()
    }, 5000);
  }


  setPage(page: number) {
    if (page < 1 || page > this.pagination.totalPages) {
      return;
    }
    // Get pagination object from service
    this.pagination = this.paginationService.getPagination(this.viewsByIps.length, page, 6);
    // Get current page of items
    this.pagedItems = this.viewsByIps.slice(this.pagination.startIndex, this.pagination.endIndex + 1);
  }

  private loadLastViews() {
    console.log("View: ", this.hashId)
    this.ViewsbackendService.getLastViews(this.hashId)
      .pipe(first())
      .subscribe(lastViews => {
        // console.log('lastviews: ', lastViews);
        this.viewsByIps = lastViews;
        this.setPage(1);
      });

  }

}
