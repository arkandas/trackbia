import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PopupService {

  constructor() {
  }

  makeViewPopup(data: any): string {
    return `` +
      `<div><b>Ip Address:</b> ${data.ipAddress}</div>` +
      `<div><b>Country:</b> ${data.country}</div>` +
      `<div><b>City:</b> ${data.city}</div>` +
      `<div><b>ASN Number:</b> ${data.asnNumber}</div>` +
      `<div><b>ASN Operator:</b> ${data.asnOperator}</div>` +
      `<div><b>Latitude:</b> ${data.latitude}</div>` +
      `<div><b>Longitude:</b> ${data.longitude}</div>`
  }
}

