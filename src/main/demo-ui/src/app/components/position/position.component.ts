import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {PositionDTO} from "../../dto/PositionDTO";
import {StrapDTO} from "../../dto/StrapDTO";
import {StrapService} from "../../service/StrapService";
import {PositionService} from "../../service/PositionService";
import {interval, Observable, observable, Subscription} from "rxjs";
import {startWith, subscribeOn} from "rxjs/operators";
import {OpenLayersMap, randomHexaColor} from "../../OpenLayersMap";
import {fromLonLat, toLonLat} from 'ol/proj';
import {SubSink} from "subsink";

/**
 * Affiche une carte sur laquelle l'on afficher la position d'un résident
 * @author Bakary Diakite
 * @version 1.0
 */
@Component({
  selector: 'app-position',
  templateUrl: './position.component.html',
  styleUrls: ['./position.component.scss']
})
export class PositionComponent implements OnInit, AfterViewInit, OnDestroy {

  /**
   * Position
   */
  position: PositionDTO;

  /**
   * Bracelets
   */
  straps: StrapDTO[] = [];

  /**
   * Carte
   */
  map: OpenLayersMap = new OpenLayersMap();

  /**
   * Souscriptions
   */
  private subs = new SubSink();

  startStopButtonText = 'Démarrer';
  isStartStopButtonToggle = false;

  /**
   *
   * @param strapService  Service de gestion des bracelets
   * @param positionService  Service des positions
   */
  constructor(private strapService: StrapService, private positionService: PositionService) {
  }

  ngOnInit() {
    this.findAllStrap();
  }

  /**
   * Récupère les bracelets
   */
  findAllStrap(): void {
    this.strapService.findAll().subscribe(straps => {
      this.straps = straps;
    });
  }

  ngAfterViewInit(): void {
    this.map.initializeMap('map');
    this.map.setOptions({asGPSTracker: true, centerOnMarker: true});
    this.map.centerAt([2.2333279252052307, 48.90928638628919]);
    this.map.setZoom(18.5);
    this.map.addGeoJSONLayer('assets/map_correcte.json', {color: 'red'});
  }

  /**
   * Affiche les 30 dernières positions du résident sélectionné
   * @param strapId Identifiant numérique du bracelet
   */
  positionHistory(strapId: bigint): void {
    this.subs.unsubscribe();
    this.map.removeMarkers();
    this.map.removeHistoryLayers();
    this.subs.add(this.positionService.positionHistory(strapId).subscribe(history => {
        const positions = history.map(position => [position.longitude, position.latitude]);
        this.map.positionsHistory(positions);
      })
    );
  }

  /**
   * Ajoute un marqueur à la position du bracelet
   * @param id Identifiant du bracelet
   */
  findPosition(id: bigint): void {
    this.map.removeHistoryLayers();
    this.subs.add(
      this.positionService.findPositionByStrap(id).subscribe(position => {
        this.map.addMarker(position.strap.id, [position.longitude, position.latitude], {textUnderMarker: `${position.strap.person.firstName}  ${position.strap.person.lastName}`});
      })
    );
  }

  ngOnDestroy(): void {
    this.subs.unsubscribe();
  }

  simulationPositionToggle() {
    let status: string;

    this.isStartStopButtonToggle = !this.isStartStopButtonToggle;
    if (this.isStartStopButtonToggle) {
      this.startStopButtonText = 'Arrêter';
      status = 'start';
    } else {
      this.startStopButtonText = 'Démarrer';
      status = 'stop';
      this.subs.unsubscribe();
    }
    this.subs.add(this.positionService.simulatePosition(status));

  }
}


