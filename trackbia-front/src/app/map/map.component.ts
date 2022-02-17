import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PopupService} from "../_services/popup.service";
import {SharedService} from "../_services/shared.service";
import {ViewsBackendService} from "../_services/views-backend.service";
import * as L from 'leaflet';

const iconRetinaUrl = 'assets/marker-icon-2x.png';
const iconUrl = 'assets/marker-icon.png';
const shadowUrl = 'assets/marker-shadow.png';
const iconDefault = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
L.Marker.prototype.options.icon = iconDefault;

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {
  clickEventSubscription: Subscription;
  markerClusterGroup!: L.MarkerClusterGroup;
  markerClusterData: any[] = [];
  markerClusterOptions!: L.MarkerClusterGroupOptions;

  @Input()
  hashId!: string;

  LAYER_OSM = {
    id: "openstreetmap",
    name: "Open Street Map",
    enabled: false,
    layer: L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    })
  };
  // Values to bind to Leaflet Directive
  layersControlOptions = {position: "bottomright"};
  baseLayers = {
    "Open Street Map": this.LAYER_OSM.layer
  };
  options = {
    zoom: 3,
    center: L.latLng([40, 0])
  };

  constructor(private sharedService: SharedService,
              private http: HttpClient,
              private popupService: PopupService,
              private ViewsbackendService: ViewsBackendService) {
    this.clickEventSubscription = this.sharedService.getClickEvent().subscribe(() => {
      // console.log('Map Component -> Reload Map Component');
      this.reloadMap();
    });
  }

  markerClusterReady(group: L.MarkerClusterGroup) {
    this.markerClusterGroup = group;
  }

  ngAfterViewInit(): void {

    this.markerClusterGroup = L.markerClusterGroup({removeOutsideVisibleBounds: true});
    this.makeViewsByIPMarkers();
    setInterval(() => {
      this.reloadMap()
    }, 5000);
  }

  makeViewsByIPMarkers(): void {
    const data: any[] = [];
    this.ViewsbackendService.getUniqueViewsByIP(this.hashId).subscribe((res: any) => {
      for (const view of res) {
        const marker = L.marker([view.latitude, view.longitude]);
        marker.bindPopup(this.popupService.makeViewPopup(view));
        data.push(marker);
      }
      this.updateComponent(data);
    });
  }

  private updateComponent(data: any[]) {
    console.log(data.length)
    this.markerClusterData = data;
  }

  private reloadMap() {
    this.makeViewsByIPMarkers();
  }


}
