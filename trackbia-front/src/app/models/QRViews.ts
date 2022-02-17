declare module QRViews {

  export interface ViewInfo {
    totalViews: number;
    totalQr: number;
    totalDay: number;
    totalWeek: number;
    totalMonth: number;
  }

  export interface QrInfo {
    creationDate: string;
    description: string;
    hashId: string;
    type: string;
    url: string;
    user_id: string;
    totalViews: string;
    id: string;
  }

  export interface RootObject {
    viewInfo: ViewInfo;
    qrInfo: QrInfo[];
  }

}
