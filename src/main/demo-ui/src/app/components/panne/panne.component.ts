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
  // tslint:disable-next-line:ban-types
  heaterBreakdown: Object = new HeaterMessageDTO();

  breakdowns = [0, 0, 0, 0, 0];
  suspects = [0, 0, 0, 0, 0];

  ngOnInit() {
    this.rooms = this.roomService.findAllRoom();
    this.refresh();
  }

  RoomDetail(room: RoomDTO) {
    this.heaters = this.heaterService.findIOTByRoom(String(room.num));
    this.clocks = this.clockService.findIOTByRoom(String(room.num));
    this.shutters = this.shutterService.findIOTByRoom(String(room.num));
    this.lights = this.lightService.findIOTByRoom(String(room.num));
  }

  breakdownHeatersDetection() {
    this.heaterService.countHeaters().subscribe( data => {
      for (let i = 1; i <= data; i++) {
        this.breakdownHeaterDetection(i.toString());
      }
    });
    setTimeout(() => {  this.refresh(); }, 2000);

  }

  async refresh() {
    this.breakdownRooms();
    this.suspectRooms();
  }

  private breakdownHeaterDetection(id: string) {
    // tslint:disable-next-line:max-line-length
    this.heaterMessageService.breakdownDetection(id).subscribe(data => {
      this.heaterBreakdown = data;
      if (data) {
        const toto = 'le radiateur ' + id + ' est en panne';
        alert(toto);
      }
      console.log('le radiateur', id , 'est en panne', data);
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
      map(data => data.map(val => val.breakdownstatus).filter(x => x == 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] = x;
      console.log('panne', index, ' - ', x); });
    this.clockService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x == 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] += x;
      console.log('panne', index, ' - ', x); });
    this.lightService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x == 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] += x;
      console.log('panne', index, ' - ', x); });
    this.shutterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.breakdownstatus).filter(x => x == 'BREAKDOWN').length)
    ).subscribe(x => {
      this.breakdowns[index] += x;
      console.log('panne', index, ' - ', x); });
  }

  // define the number of object suspect in a room and change the array suspects
  suspectRoom(index: string) {
    this.heaterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x == 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] = x;
      console.log('suspect', index, ' - ', x); });
    this.clockService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x == 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] += x;
      console.log('suspect', index, ' - ', x); });
    this.lightService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x == 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] += x;
      console.log('suspect', index, ' - ', x); });
    this.shutterService.findIOTByRoom(String(index)).pipe(
      map(data => data.map(val => val.suspect).filter(x => x == 'SUSPECT').length)
    ).subscribe(x => {
      this.suspects[index] += x;
      console.log('suspect', index, ' - ', x); });
 }

}
