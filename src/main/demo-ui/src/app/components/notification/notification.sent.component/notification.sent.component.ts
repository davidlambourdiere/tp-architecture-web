import {Component, OnInit} from "@angular/core";
import {PersonDTO} from "../../../dto/PersonDTO";
import {NotificationContainerInitializeDTO} from "../../../dto/NotificationContainerInitializeDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {NotificationService} from "../../../service/NotificationService";
import {NotificationDTO} from "../../../dto/NotificationDTO";

@Component({
  selector: 'notification/sent',
  templateUrl: './notification.sent.component.html',
  styleUrls: ['./notification.sent.component.scss']
})
export class NotificationSentComponent implements OnInit {

  userConnected: PersonDTO;
  messagesSent: NotificationDTO[];

  ngOnInit(): void {
    this.getUserConnected();
    this.getMessagesSent();
  }

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService,
              private notificationService: NotificationService) {
  }

  getLogin() {
    return this.authService.getUser().login;
  }


  getUserConnected(): void {
    this.route.params.subscribe(params => {
      this.notificationService.findUser(this.getLogin()).subscribe(data => {
        this.userConnected = data;
      })
    })
  }

  private getMessagesSent(): void {
    this.route.params.subscribe(params => {
      this.notificationService.findMessagesSent(this.getLogin()).subscribe(data => {
        this.messagesSent = data;
      })
    })
  }
}
