import {Component, OnInit} from "@angular/core";
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {HeaterService} from "../../../service/HeaterService";
import {ClockDTO} from "../../../dto/ClockDTO";
import {ClockService} from "../../../service/ClockService";
import {NotificationService} from "../../../service/NotificationService";
import {NotificationDTO} from "../../../dto/NotificationDTO";
import {PersonDTO} from "../../../dto/PersonDTO";
import {AuthService} from "../../../service/AuthService";

@Component({
  selector: 'notification/clock',
  templateUrl: './notification.clock.component.html',
  styleUrls: ['./notification.clock.component.scss']
})
export class NotificationClockComponent implements OnInit{

  id: string;
  formtype: string = '';
  concerningobject: string;
  personneconcerning:string;
  clock: ClockDTO;
  message: NotificationDTO;
  comment: string ='';
  userConnected: PersonDTO = null;

  constructor(private router: Router, private route: ActivatedRoute, private clockService: ClockService,
              private notificationService: NotificationService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findClock();
    this.getUserConnected();
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

  findClock(): void{
    this.route.params.subscribe(params => {
      this.clockService.findClock(this.id).subscribe(data => {
        this.clock = data;
      })
    })
  }
  constructMessageToSend(): void{
    this.message = new NotificationDTO();
    this.message.destinataire = this.clock.person.login;
    this.message.emetteur = this.userConnected.login;
    this.message.message = this.comment;
  }

  sendMessage(): void{
    this.constructMessageToSend();
    this.route.params.subscribe(params =>{
      this.notificationService.sendMessage(this.message).subscribe(data => {
        this.message = data;
      })
    })
  }
}

