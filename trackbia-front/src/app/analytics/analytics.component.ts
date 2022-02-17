import {Component, OnInit} from '@angular/core';
import {first} from "rxjs/operators";
import {TotalViews} from "../models/totalViews";
import {
  faCalendarAlt,
  faCalendarDay,
  faCalendarWeek,
  faEye,
  faGlobeAmericas,
  faUserAstronaut
} from "@fortawesome/free-solid-svg-icons";
import {Subscription} from "rxjs";
import {ViewsBackendService} from "../_services/views-backend.service";
import {SharedService} from "../_services/shared.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.scss']
})
export class AnalyticsComponent implements OnInit {
  faCalendarDay = faCalendarDay;
  faCalendarWeek = faCalendarWeek;
  faCalendarMonth = faCalendarAlt;
  faUniqueVisitor = faUserAstronaut;
  faTotalViewsIcon = faEye;
  faFlagIcon = faGlobeAmericas;
  public hashId: string = '';


  clickEventSubscription: Subscription;
  totalViewsLocal = new TotalViews(0, 0, 0, 0, 0, 0);

  constructor(private ViewsbackendService: ViewsBackendService,
              private sharedService: SharedService,
              private router: Router,
              private route: ActivatedRoute) {

    this.clickEventSubscription = this.sharedService.getClickEvent().subscribe(() => {
      // console.log('Home Component -> Reload Total Views');
      this.loadTotalViews();
    })

  }

  ngOnInit(): void {
    this.hashId = <string>this.route.snapshot.paramMap.get('hash');
    this.loadTotalViews();
    setInterval(() => {
      this.loadTotalViews()
    }, 5000);

  }

  private loadTotalViews() {
    this.ViewsbackendService.getTotalViews(this.hashId)
      .pipe(first())
      .subscribe(totalViews => {
        // console.log(totalViews);
        this.totalViewsLocal = totalViews;
      });
  }

}
