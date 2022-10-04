import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {ProfileComponent} from "./profile/profile.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {AnalyticsComponent} from "./analytics/analytics.component";

const routes: Routes = [
  { path: 'home/:hash', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'analytics/:hash', component: AnalyticsComponent},
  { path: 'home', redirectTo: 'home/default', pathMatch: 'full'},
  { path: '', redirectTo: 'home/default', pathMatch: 'full' }
];

export const appRoutingModule = RouterModule.forRoot(routes);
