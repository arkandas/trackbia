import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {map} from "rxjs/operators";
import {SeccryptoService} from "./seccrypto.service";
import {DeviceDetectorService} from 'ngx-device-detector';
import {environment} from "../../environments/environment";
import {UserView} from "../models/UserView";


const AUTH_API = environment.apiUrl + '/api/page/';


@Injectable({
  providedIn: 'root'
})
export class PageService {

  constructor(private http: HttpClient, private deviceService: DeviceDetectorService, private secCryptoServer: SeccryptoService) {
  }

  getQrViews() {
    return this.http.get<any>(AUTH_API + `qrviews`, {})
      .pipe(map((qrViews: any) => {
        console.log('qrViews: ', qrViews);
        return qrViews;
      }));
  }

  sendUserView(page: string, hashId: string) {
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

    // console.log(pageView);
    // console.log('Sending data to: ' + environment.apiUrl + '/pageview');

    // console.log("Date: " + pageView.date);
    const SecHTag = this.secCryptoServer.encryptUsingAES256(
      pageView.page +
      pageView.userBrowser +
      pageView.userBrowserVersion +
      pageView.userDevice +
      pageView.userDeviceType +
      pageView.userOS +
      pageView.userOSVersion +
      pageView.date
    ).toString();
    // console.log("SecTag:" + SecHTag);
    const decTag = this.secCryptoServer.decryptUsingAES256(SecHTag);
    // console.log("DecTag: " + decTag);

    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json', 'SECHTAG': SecHTag})
    };

    console.log(httpOptions.headers);
    return this.http.post(AUTH_API + 'view', pageView, httpOptions);
  }


}
