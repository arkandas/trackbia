export class TotalViews {
  private _totalViews: any;
  private _uniqueVisitors: any;
  private _countries: any;
  private _lastDay: any;
  private _lastWeek: any;
  private _lastMonth: any;

  constructor(totalViews: any, uniqueVisitors: any, countries: any, lastDay: any, lastWeek: any, lastMonth: any) {
    this._totalViews = totalViews;
    this._uniqueVisitors = uniqueVisitors;
    this._countries = countries;
    this._lastDay = lastDay;
    this._lastWeek = lastWeek;
    this._lastMonth = lastMonth;
  }

  get totalViews(): any {
    return this._totalViews;
  }

  set totalViews(value: any) {
    this._totalViews = value;
  }

  get uniqueVisitors(): any {
    return this._uniqueVisitors;
  }

  set uniqueVisitors(value: any) {
    this._uniqueVisitors = value;
  }

  get countries(): any {
    return this._countries;
  }

  set countries(value: any) {
    this._countries = value;
  }

  get lastDay(): any {
    return this._lastDay;
  }

  set lastDay(value: any) {
    this._lastDay = value;
  }

  get lastWeek(): any {
    return this._lastWeek;
  }

  set lastWeek(value: any) {
    this._lastWeek = value;
  }

  get lastMonth(): any {
    return this._lastMonth;
  }

  set lastMonth(value: any) {
    this._lastMonth = value;
  }
}
