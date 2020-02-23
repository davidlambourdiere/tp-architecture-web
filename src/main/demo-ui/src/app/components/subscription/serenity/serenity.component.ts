import { Component, OnInit } from '@angular/core';
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";
import {SubscriptionResidentDTO} from "../../../dto/SubscriptionResidentDTO";

@Component({
  selector: 'app-serenity',
  templateUrl: './serenity.component.html',
  styleUrls: ['./serenity.component.scss']
})
export class SerenityComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;
  login: string;
  residentSubscriptionDTO: SubscriptionResidentDTO;

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
    this.name = 'serenity';
    console.log(JSON.stringify(this.name));
    this.showSubscriptionSerenity();
  }

  validate() {
    this.router.navigate(["home"]);
  }

  redirectToCustomPage() {
    this.router.navigate(["custom"]);
  }

  showSubscriptionSerenity() {
    this.route.params.subscribe(params => {
      this.subservice.findSubscriptionByProfile(this.name).subscribe(data => {
        this.subscriptions = data;

      });
    });
  }

  insertSubscriptionResident() {
    this.login = JSON.parse(localStorage.getItem('user'));
    console.log(this.login);
    this.route.params.subscribe(params => {
      this.subservice.insertNewResidentInSubscription(this.subscriptions, this.login).subscribe(data => {
        this.subscriptions = data;
      });
    });
    this.validate();
  }
}
