import {Component, OnInit} from "@angular/core";
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {HeaterService} from "../../../service/HeaterService";
import {LightDTO} from "../../../dto/LightDTO";
import {LightService} from "../../../service/LightService";
import {NotificationService} from "../../../service/NotificationService";
import {AuthService} from "../../../service/AuthService";
import {NotificationDTO} from "../../../dto/NotificationDTO";
import {PersonDTO} from "../../../dto/PersonDTO";

@Component({
  selector: 'notification/light',
  templateUrl: './notification.light.component.html',
  styleUrls: ['./notification.light.component.scss']
})
export class NotificationLightComponent implements OnInit{

  id: string;
  formtype: string = '';
  concerningobject: string;
  personneconcerning:string;
  light: LightDTO;
  message: NotificationDTO;
  comment: string ='';
  userConnected: PersonDTO = null;

  constructor(private router: Router, private route: ActivatedRoute, private lightService: LightService,
              private notificationService: NotificationService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findLight();
    this.getUserConnected();
  }

  findLight(): void{
    this.route.params.subscribe(params => {
      this.lightService.findLight(this.id).subscribe(data => {
        this.light = data;
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
    this.message.destinataire = this.light.person.login;
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
