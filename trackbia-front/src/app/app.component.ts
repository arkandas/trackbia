import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TokenStorageService} from "./_services/token-storage.service";
import {faChartBar, faChartLine, faChartPie, faDownload, faHome} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'trackbia';
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  faDashboard = faChartBar;
  faHome = faHome;

  constructor(private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');

      this.username = user.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }


  @ViewChild('navBurger') navBurger: ElementRef | undefined;
  @ViewChild('navMenu') navMenu: ElementRef | undefined;

  toggleNavbar() {
    // @ts-ignore
    this.navBurger.nativeElement.classList.toggle('is-active');
    // @ts-ignore
    this.navMenu.nativeElement.classList.toggle('is-active');
  }

}
