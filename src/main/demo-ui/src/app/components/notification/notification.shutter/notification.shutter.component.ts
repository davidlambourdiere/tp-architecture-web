import {Component, OnInit} from "@angular/core";
import {LightDTO} from "../../../dto/LightDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {LightService} from "../../../service/LightService";
import {ShutterDetailDTO} from "../../../dto/ShutterDetailDTO";
import {ShutterDTO} from "../../../dto/ShutterDTO";
import {ShutterService} from "../../../service/ShutterService";
import {NotificationService} from "../../../service/NotificationService";
import {AuthService} from "../../../service/AuthService";
import {NotificationDTO} from "../../../dto/NotificationDTO";
import {PersonDTO} from "../../../dto/PersonDTO";

@Component({
  selector: 'notification/shutter',
  templateUrl: './notification.shutter.component.html',
  styleUrls: ['./notification.shutter.component.scss']
})
export class NotificationShutterComponent implements OnInit{

  id: string;
  formtype: string = '';
  concerningobject: string;
  personneconcerning:string;
  shutter: ShutterDTO;
  message: NotificationDTO;
  comment: string ='';
  userConnected: PersonDTO = null;

  constructor(private router: Router, private route: ActivatedRoute, private shutterService: ShutterService,
              private notificationService: NotificationService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findShutter();
    this.getUserConnected();
  }

  findShutter(): void{
    this.route.params.subscribe(params => {
      this.shutterService.findShutter(this.id).subscribe(data => {
        this.shutter = data;
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
    this.message.destinataire = this.shutter.person.login;
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
