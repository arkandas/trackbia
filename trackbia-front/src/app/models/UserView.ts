export class UserView {

  page!: string;
  userBrowser!: string;
  userBrowserVersion!: string;
  userDevice!: string;
  userDeviceType!: string;
  userOS!: string;
  userOSVersion!: string;
  date!: string;
  hashId!: string;


  constructor(page: string, userBrowser: string, userBrowserVersion: string, userDevice: string, userDeviceType: string, userOS: string, userOSVersion: string, hashId: string) {
    this.page = page;
    this.userBrowser = userBrowser;
    this.userBrowserVersion = userBrowserVersion;
    this.userDevice = userDevice;
    this.userDeviceType = userDeviceType;
    this.userOS = userOS;
    this.userOSVersion = userOSVersion;
    this.date = new Date().toISOString();
    this.hashId = hashId;
  }
}
