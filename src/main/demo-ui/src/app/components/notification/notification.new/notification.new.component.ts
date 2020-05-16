import {Component, OnInit} from "@angular/core";
import {PersonDTO} from "../../../dto/PersonDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {NotificationService} from "../../../service/NotificationService";
import {PersonService} from "../../../service/PersonService";
import {FormControl} from "@angular/forms";
import {ShutterService} from "../../../service/ShutterService";
import {LightService} from "../../../service/LightService";
import {ClockService} from "../../../service/ClockService";
import {StrapService} from "../../../service/StrapService";
import {HeaterService} from "../../../service/HeaterService";
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {ShutterDTO} from "../../../dto/ShutterDTO";
import {LightDTO} from "../../../dto/LightDTO";
import {ClockDTO} from "../../../dto/ClockDTO";
import {StrapDTO} from "../../../dto/StrapDTO";

@Component({
  selector: 'notification/new',
  templateUrl: './notification.new.component.html',
  styleUrls: ['./notification.new.component.scss']
})
export class NotificationNewComponent implements OnInit {

  userConnected: PersonDTO = null;
  allusers:PersonDTO[] =null;
  myControl = new FormControl();
  personneconcerning: string;
  destinataire:string = '';
  formtype: string = '';
  concerningobject: string;
  objecttype: string;
  heater: HeaterDTO;
  shutter: ShutterDTO;
  light: LightDTO;
  clock: ClockDTO;
  strap: StrapDTO;
  id: string;
  allHeater: HeaterDTO[];
  allShutter: ShutterDTO[];
  allClock: ClockDTO[];
  allLight: LightDTO[];
  allStrap: StrapDTO[];

  ngOnInit(): void {
    this.getUserConnected();
    this.getAllUsers();
  }

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService,
              private notificationService: NotificationService, private personService: PersonService, private shutterService: ShutterService,
              private lightService: LightService, private clockService: ClockService, private strapService:StrapService, private heaterService: HeaterService) {
  }

  getLogin() {
    return this.authService.getUser().login;
  }

  getUserConnected(): void{
    this.route.params.subscribe(params => {
      this.notificationService.findUser(this.getLogin()).subscribe(data => {
        this.userConnected = data;
      })
    })
  }

  private getAllUsers(): void {
    this.route.params.subscribe(params => {
      this.personService.findAllPerson().subscribe(data => {
        this.allusers = data;
      })
    })
  }

  findLight(): void{
    this.route.params.subscribe(params => {
      this.lightService.findLight(this.id).subscribe(data => {
        this.light = data;
      })
    })
  }

  findHeater(): void{
    this.route.params.subscribe(params => {
      this.heaterService.findHeater(this.id).subscribe(data => {
        this.heater = data;
      })
    })
  }

  findClock(): void{
    this.route.params.subscribe(params => {
      this.clockService.findClock(this.id).subscribe(data => {
        this.clock = data;
      })
    })
  }

  findShutter(): void{
    this.route.params.subscribe(params => {
      this.shutterService.findShutter(this.id).subscribe(data => {
        this.shutter = data;
      })
    })
  }

  findStrap(): void{
    this.route.params.subscribe(params => {
      this.strapService.findStrap(this.id).subscribe(data => {
        this.strap = data;
      })
    })
  }
}
