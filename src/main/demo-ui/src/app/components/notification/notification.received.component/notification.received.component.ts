import {Component, OnInit} from "@angular/core";
import {PersonDTO} from "../../../dto/PersonDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {NotificationService} from "../../../service/NotificationService";
import {NotificationDTO} from "../../../dto/NotificationDTO";

@Component({
  selector: 'notification/received',
  templateUrl: './notification.received.component.html',
  styleUrls: ['./notification.received.component.scss']
})
export class NotificationReceivedComponent implements OnInit {

  userConnected: PersonDTO;
  messageReceived: NotificationDTO[];

  ngOnInit(): void {
    this.getUserConnected();
    this.getMessagesReceived();
  }

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService,
              private notificationService: NotificationService) {
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

  private getMessagesReceived(): void{
    this.route.params.subscribe(params => {
      this.notificationService.findMessagesReceived(this.getLogin()).subscribe(data => {
        this.messageReceived = data;
      })
    })
  }
}
