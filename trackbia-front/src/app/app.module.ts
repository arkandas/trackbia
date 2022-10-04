import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { appRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {HttpClientModule} from "@angular/common/http";
import {LeafletMarkerClusterDirective, LeafletMarkerClusterModule} from "@asymmetrik/ngx-leaflet-markercluster";
import {LeafletModule} from "@asymmetrik/ngx-leaflet";
import {HomeComponent} from "./home/home.component";
import {ProfileComponent} from "./profile/profile.component";
import {LoginComponent} from "./login/login.component";
import {MapComponent} from "./map/map.component";
import {RegisterComponent} from "./register/register.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {ViewCardListComponent} from "./view-card-list/view-card-list.component";
import {DatePipe, LowerCasePipe} from "@angular/common";
import {QRCodeModule} from "angular2-qrcode";
import {AuthService} from "./_services/auth.service";
import {AuthInterceptor} from "./_helpers/auth.interceptor";
import {PageService} from "./_services/page.service";
import {PaginationService} from "./_services/pagination.service";
import {PopupService} from "./_services/popup.service";
import {QrService} from "./_services/qr.service";
import {SeccryptoService} from "./_services/seccrypto.service";
import {SharedService} from "./_services/shared.service";
import {TokenStorageService} from "./_services/token-storage.service";
import {UserService} from "./_services/user.service";
import {ViewsBackendService} from "./_services/views-backend.service";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ProfileComponent,
    MapComponent,
    RegisterComponent,
    DashboardComponent,
    ViewCardListComponent,
    LeafletMarkerClusterDirective,
    DatePipe,
    LowerCasePipe
  ],
  imports: [
    BrowserModule,
    appRoutingModule,
    HttpClientModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    LeafletModule,
    LeafletMarkerClusterModule,
    QRCodeModule
  ],
  providers: [
    AuthService,
    AuthInterceptor,
    PageService,
    PaginationService,
    PopupService,
    QrService,
    SeccryptoService,
    SharedService,
    TokenStorageService,
    UserService,
    ViewsBackendService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
