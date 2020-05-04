import {Component, OnInit} from "@angular/core";
import {ShutterDTO} from "../../../dto/ShutterDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {ShutterService} from "../../../service/ShutterService";
import {StrapDTO} from "../../../dto/StrapDTO";
import {StrapService} from "../../../service/StrapService";
import {NotificationDTO} from "../../../dto/NotificationDTO";
import {PersonDTO} from "../../../dto/PersonDTO";
import {NotificationService} from "../../../service/NotificationService";
import {AuthService} from "../../../service/AuthService";

@Component({
  selector: 'notification/strap',
  templateUrl: './notification.strap.component.html',
  styleUrls: ['./notification.strap.component.scss']
})
export class NotificationStrapComponent implements OnInit{

  id: string;
  formtype: string = '';
  concerningobject: string;
  personneconcerning:string;
  strap: StrapDTO;
  message: NotificationDTO;
  comment: string ='';
  userConnected: PersonDTO = null;

  constructor(private router: Router, private route: ActivatedRoute, private strapService: StrapService,
              private notificationService: NotificationService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findStrap();
    this.getUserConnected();
}

  findStrap(): void{
    this.route.params.subscribe(params => {
      this.strapService.findStrap(this.id).subscribe(data => {
        this.strap = data;
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
    this.message.destinataire = this.strap.person.login;
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
