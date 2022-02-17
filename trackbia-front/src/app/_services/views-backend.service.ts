import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {map} from "rxjs/operators";

const AUTH_API = environment.apiUrl + '/api/page/';


@Injectable({
  providedIn: 'root'
})
export class ViewsBackendService {

  constructor(private http: HttpClient) {
  }

  getTotalViews(hashId: string) {
    return this.http.get<any>(AUTH_API + `totalviews/` + hashId, {})
      .pipe(map(totalViews => {
        // console.log('totalViews: ', totalViews);
        return totalViews;
      }));
  }

  getLastViews(hashId: string) {
    return this.http.get<any>(AUTH_API + `lastviews/` + hashId, {})
      .pipe(map(lastViews => {
        // console.log('lastViews: ', lastViews);
        return lastViews;
      }));
  }

  getUniqueViewsByIP(hashId: string) {
    return this.http.get<any>(AUTH_API + `viewsbyip/` + hashId, {})
      .pipe(map(uniqueViewsByIp => {
        // console.log('uniqueViewsByIp: ', uniqueViewsByIp);
        return uniqueViewsByIp;
      }));
  }

}
