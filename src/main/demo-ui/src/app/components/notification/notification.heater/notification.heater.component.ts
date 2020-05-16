import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {HeaterService} from "../../../service/HeaterService";
import {NotificationService} from "../../../service/NotificationService";
import {AuthService} from "../../../service/AuthService";
import {NotificationDTO} from "../../../dto/NotificationDTO";
import {PersonDTO} from "../../../dto/PersonDTO";

@Component({
  selector: 'notification/heater',
  templateUrl: './notification.heater.component.html',
  styleUrls: ['./notification.heater.component.scss']
})
export class NotificationHeaterComponent implements OnInit{

  id: string;
  formtype: string = '';
  concerningobject: string;
  personneconcerning:string;
  heater: HeaterDTO;
  message: NotificationDTO;
  comment: string ='';
  userConnected: PersonDTO = null;

  constructor(private router: Router, private route: ActivatedRoute, private heaterService: HeaterService,
              private notificationService: NotificationService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findHeater();
    this.getUserConnected();
  }

  findHeater(): void{
    this.route.params.subscribe(params => {
      this.heaterService.findHeater(this.id).subscribe(data => {
        this.heater = data;
      })
    })
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

  constructMessageToSend(): void{
    this.message = new NotificationDTO();
    this.message.destinataire = this.heater.person.login;
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
