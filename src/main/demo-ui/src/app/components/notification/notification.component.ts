import {Component, OnInit} from "@angular/core";
import {AuthService} from "../../service/AuthService";
import {ActivatedRoute, Router} from "@angular/router";
import {StrapService} from "../../service/StrapService";
import {PersonDTO} from "../../dto/PersonDTO";
import {NotificationService} from "../../service/NotificationService";
import {NotificationContainerInitializeDTO} from "../../dto/NotificationContainerInitializeDTO";

@Component({
  selector: 'notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss']
})
export class NotificationComponent implements OnInit {

  userConnected: PersonDTO = null;
  initializeNotification: NotificationContainerInitializeDTO = null;

  ngOnInit(): void {
    this.getUserConnected();
    this.initializedNotification();
  }

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService,
              private notificationService: NotificationService) {
  }

  getLogin() {
    return this.authService.getUser().login;
  }

  initializedNotification(): void{
    this.route.params.subscribe(params => {
      this.notificationService.initializedNotification(this.getLogin()).subscribe(data => {
        this.initializeNotification = data;
      })
    })
  }

  getUserConnected(): void{
    this.route.params.subscribe(params => {
      this.notificationService.findUser(this.getLogin()).subscribe(data => {
        this.userConnected = data;
      })
    })
  }

}
