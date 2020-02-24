import { Component, OnInit } from '@angular/core';
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";
import {SubscriptionResidentDTO} from "../../../dto/SubscriptionResidentDTO";
import {PersonDTO} from "../../../dto/PersonDTO";

@Component({
  selector: 'app-serenity',
  templateUrl: './serenity.component.html',
  styleUrls: ['./serenity.component.scss']
})
export class SerenityComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;
  login: string;
  person: PersonDTO;
  residentSubscriptionDTO: SubscriptionResidentDTO;

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
    this.name = 'serenity';
    this.showSubscriptionSerenity();
    this.login = this.route.snapshot.paramMap.get('login');
  }

  validate() {
    this.router.navigate(['home']);
  }

  redirectToCustomPage() {
    this.router.navigate(['custom']);
  }

  showSubscriptionSerenity() {
    this.route.params.subscribe(params => {
      this.subservice.findSubscriptionByProfile(this.name).subscribe(data => {
        this.subscriptions = data;

      });
    });
  }

  insertSubscriptionResident() {
    console.log(this.login);
    this.route.params.subscribe(params => {
      this.subservice.insertNewResidentInSubscription(this.subscriptions, this.login).subscribe(data => {
        this.subscriptions = data;
      });
    });
    this.validate();
  }
}
