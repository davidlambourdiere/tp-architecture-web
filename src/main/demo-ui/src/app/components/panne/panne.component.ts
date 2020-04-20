import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IOTService} from '../../service/IOTService';
import {IOTDTO} from '../../dto/IOTDTO';
import {ClockService} from '../../service/ClockService';
import {Observable, OperatorFunction, Subscription} from 'rxjs';
import {map} from 'rxjs/operators';
import {RoomService} from '../../service/RoomService';
import {RoomDTO} from '../../dto/RoomDTO';
import {HeaterMessageService} from '../../service/HeaterMessageService';
import {HeaterMessageDTO} from '../../dto/HeaterMessageDTO';
import {HeaterService} from '../../service/HeaterService';
import {LightService} from '../../service/LightService';
import {ShutterService} from '../../service/ShutterService';




@Component({
  // tslint:disable-next-line:component-selector
  selector: 'panne',
  templateUrl: './panne.component.html',
  styleUrls: ['./panne.component.scss']
})
export class PanneComponent implements OnInit {

  // tslint:disable-next-line:max-line-length
  constructor(private router: Router,
              private route: ActivatedRoute,
              private iotservice: IOTService,
              private clockService: ClockService,
              private heaterService: HeaterService,
              private lightService: LightService,
              private shutterService: ShutterService,
              private roomService: RoomService,
              private heaterMessageService: HeaterMessageService) {

  }
  heaters: Observable<any>;
  clocks: Observable<any>;
  lights: Observable<any>;
  shutters: Observable<any>;
  rooms: Observable<any>;
  countBrekdown: number;
  countBreakdownNew: number;

  // tslint:disable-next-line:ban-types
  heaterBreakdown: Object = new HeaterMessageDTO();

  // TODO : Dedend on number of room (create loop)
  breakdowns = [0, 0, 0, 0, 0];
  suspects = [0, 0, 0, 0, 0];

  numRoomCliked = '0';

  String;
  ngOnInit() {
    this.rooms = this.roomService.findAllRoom();
    this.refresh();
    this.breakdownHeatersDetection();
  }

  async refresh() {
    this.breakdownRooms();
    this.suspectRooms();
    // count the number of breakdown at this moment before the detection
    this.CountBreakdown(true);
    console.log('Je suis dans le refresh');
    setTimeout(() => {this.breakdownHeatersDetection(); }, 28000);
  }

  revive() {
    console.log('Je suis dans le revive');
    setTimeout(() => {this.breakdownHeatersDetection(); }, 28000);
  }

  CountBreakdown(wOne: boolean) {
    // True for first, false for new count
    this.heaterService.findAllHeater().pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x === 'BREAKDOWN').length)
    ).subscribe(x => {
      if (wOne) {
        this.countBrekdown = x;
      } else {
        this.countBreakdownNew = x;
      }
    });
  }

  RoomDetail(room: RoomDTO) {
    this.numRoomCliked = room.num;
    this.heaters = this.heaterService.findIOTByRoom(String(room.num));
    this.clocks = this.clockService.findIOTByRoom(String(room.num));
    this.shutters = this.shutterService.findIOTByRoom(String(room.num));
    this.lights = this.lightService.findIOTByRoom(String(room.num));
  }

  breakdownHeatersDetection() {
    this.heaterService.findAllHeater().pipe().subscribe(x => {
      let i = 0;
      while (i < x.length) {
        // console.log('ID : ', x[i]['id'], ' PANNE : ', x[i]['breakdownstatus']);
        if (x[i]['breakdownstatus'] === 'NOT_BREAKDOWN') {
          console.log('Ok je vais chercher les pannes pour le radiateur', x[i]['id']);
          this.breakdownHeaterDetection(x[i]['id']);
        }
        i++;
      }
    });
    // To count the number of IOT in breakdown after the detection
    this.CountBreakdown(false);
    setTimeout(() => {
      console.log('Le vieux ', this.countBrekdown, 'Le nouveau', this.countBreakdownNew);
      if (this.countBrekdown !== this.countBreakdownNew) {
        // if the number of breakdown has changed, it have to refresh the window
        console.log('Ok je refresh');
        this.refresh();
      } else {
        // else juste revive the function breakdownHeatersDetection
        this.revive();
      }
    }, 2000);

  }

  private breakdownHeaterDetection(id: string) {
    // tslint:disable-next-line:max-line-length
    this.heaterMessageService.breakdownDetection(id).subscribe(data => {
      this.heaterBreakdown = data;
      if (data) {
        const msg = 'le radiateur ' + id + ' est en panne';
        alert(msg);
      }
    } );
  }


  // Define the number of object in breakdown in a housing
  breakdownRooms() {
    // TODO : a loop with the number of rooms (ForEach?)
    this.breakdownRoom('1');
    this.breakdownRoom('2');
    this.breakdownRoom('3');
    this.breakdownRoom('4');
    this.breakdownRoom('5');
    // setTimeout(() => {  this.refresh(); }, 2000);
  }


  suspectRooms() {
    // TODO : a loop with the number of rooms (ForEach?)
    this.suspectRoom('1');
    this.suspectRoom('2');
    this.suspectRoom('3');
    this.suspectRoom('4');
    this.suspectRoom('5');
  }


  // define the number of object in breakdown in a room and change the array breakdowns
  breakdownRoom(index: string) {
    this.heaterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x === 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] = x;
      console.log('panne', index, ' - ', x); });
    this.clockService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x === 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] += x;
      console.log('panne', index, ' - ', x); });
    this.lightService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x === 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] += x;
      console.log('panne', index, ' - ', x); });
    this.shutterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x === 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] += x;
      console.log('panne', index, ' - ', x); });
  }

  // define the number of object suspect in a room and change the array suspects
  suspectRoom(index: string) {
    this.heaterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x === 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] = x;
      console.log('suspect', index, ' - ', x); });
    this.clockService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x === 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] += x;
      console.log('suspect', index, ' - ', x); });
    this.lightService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x === 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] += x;
      console.log('suspect', index, ' - ', x); });
    this.shutterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x === 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] += x;
      console.log('suspect', index, ' - ', x); });
 }

}
