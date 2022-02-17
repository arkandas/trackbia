import {Component, OnInit} from '@angular/core';
import {UserService} from "../_services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {first} from "rxjs/operators";
import {DeviceDetectorService} from "ngx-device-detector";
import {PageService} from "../_services/page.service";
import {QrService} from "../_services/qr.service";
import {
  faBusinessTime, faChartPie, faMarsDouble,
  faRegistered,
  faSolarPanel,
  faSpaceShuttle, faTableTennis,
  faUserAstronaut
} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public hashId: string = '';
  content?: string;
  faSpaceShip = faUserAstronaut;
  faBusiness = faBusinessTime;
  faTechnology = faSolarPanel;
  faMarketing = faTableTennis;
  faEnvironment = faChartPie;

  constructor(private route: ActivatedRoute, private router: Router, private qrService: QrService) {
  }

  ngOnInit(): void {
    this.hashId = <string>this.route.snapshot.paramMap.get('hash');
    console.log("Hash Id: " + this.router.url);


    this.qrService.createQrView(this.router.url, this.hashId)
      .pipe(first())
      .subscribe(
        data => {
          console.log('success: ', data)
        },
        error => {
          // console.log('error: ' + error)
        });


  }
}
