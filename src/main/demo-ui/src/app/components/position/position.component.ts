import {AfterViewInit, Component, OnInit} from '@angular/core';
import {PositionDTO} from "../../dto/PositionDTO";
import {StrapDTO} from "../../dto/StrapDTO";
import {StrapService} from "../../service/StrapService";
import {PositionService} from "../../service/PositionService";
import {interval, Observable, observable} from "rxjs";
import {startWith, subscribeOn} from "rxjs/operators";
import {OpenLayersMap} from "../../OpenLayersMap";

@Component({
  selector: 'app-position',
  templateUrl: './position.component.html',
  styleUrls: ['./position.component.scss']
})
export class PositionComponent implements OnInit, AfterViewInit {
  position: PositionDTO;
  straps: StrapDTO[] = [];
  map: OpenLayersMap = new OpenLayersMap();

  constructor(private strapService: StrapService, private positionService: PositionService) {

  }

  ngOnInit() {
    this.findAllStrap();
  }

  findAllStrap(): void {
    this.strapService.findAll().subscribe(straps=>{this.straps = straps; console.log(straps)});
  }

  findPositionByStrap(strapId: bigint): void{
    /*this.positionService.findPositionByStrap(strapId).pipe(
      interval(5000),
      startWith(0)
    ).subscribe()*/
    this.positionService.findPositionByStrap(strapId).subscribe(position => console.log(position));
  }

  ngAfterViewInit(): void {
    this.map.initializeMap('map');
    this.map.setOptions({asGPSTracker: true});
    this.map.centerAt([2.2333279252052307,48.90928638628919]);
    this.map.setZoom(18.5);
    //this.map.addMarker([2.2333279252052307,48.90928638628919], {color: 'blue'});
    //this.map.addMarker([2.2329899668693542,48.90903958105264], {color: 'beige', textUnderMarker: 'jean-paul', id: 'jp'});
    //this.map.addMarker([2.2328585386276245,48.90918413855337], {textUnderMarker: 'jean-claude'});
    //this.map.drawLineBetweenEachMarker({withDistance: true});
    this.map.addGeoJSONLayer('assets/map.json', {color: 'red'});
    //this.map.removeFeature('jp');

  }

  findPosition(id: bigint): void {
    this.positionService.findPositionByStrap(id).subscribe(position => {
      this.map.addMarker([position.latitude, position.longitude])
      console.log(position);
    });

  }



}
