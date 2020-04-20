import {Component, OnInit} from "@angular/core";
import {PersonDTO} from "../../../dto/PersonDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {NotificationService} from "../../../service/NotificationService";
import {PersonService} from "../../../service/PersonService";

@Component({
  selector: 'notification/new',
  templateUrl: './notification.new.component.html',
  styleUrls: ['./notification.new.component.scss']
})
export class NotificationNewComponent implements OnInit {

  userConnected: PersonDTO;
  allusers:PersonDTO[];

  ngOnInit(): void {
    this.getUserConnected();
    this.getAllUsers();
  }

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService,
              private notificationService: NotificationService, private personService: PersonService) {
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
}
