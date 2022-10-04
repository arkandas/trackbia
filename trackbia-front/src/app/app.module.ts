import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {appRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import {HomeComponent} from "./home/home.component";
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {RegisterComponent} from "./register/register.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "./login/login.component";
import {ProfileComponent} from "./profile/profile.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {QRCodeModule} from "angular2-qrcode";
import {PaginationService} from "./_services/pagination.service";
import {AuthInterceptor} from "./_helpers/auth.interceptor";
import {AnalyticsComponent} from "./analytics/analytics.component";
import {ViewCardListComponent} from "./view-card-list/view-card-list.component";
import {MapComponent} from "./map/map.component";
import {LeafletModule} from '@asymmetrik/ngx-leaflet';
import {LeafletMarkerClusterModule} from "@asymmetrik/ngx-leaflet-markercluster";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    ProfileComponent,
    DashboardComponent,
    AnalyticsComponent,
    ViewCardListComponent,
    MapComponent
  ],
  imports: [
    BrowserModule,
    appRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    HttpClientModule,
    CommonModule,
    QRCodeModule,
    LeafletModule,
    LeafletMarkerClusterModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    PaginationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
