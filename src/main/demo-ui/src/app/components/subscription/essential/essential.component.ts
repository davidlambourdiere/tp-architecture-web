import { Component, OnInit } from '@angular/core';
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";
import {SubscriptionResidentDTO} from "../../../dto/SubscriptionResidentDTO";

@Component({
  selector: 'app-essential',
  templateUrl: './essential.component.html',
  styleUrls: ['./essential.component.scss']
})
export class EssentialComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;
  login: string;
  residentSubscriptionDTO: SubscriptionResidentDTO;


  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
   // this.name = this.route.snapshot.paramMap.get('name');
  this.name = 'essential';
  console.log(JSON.stringify(this.name));
    this.showSubscriptionEssential();
  }

  validate() {
    this.router.navigate(["home"]);
  }

  redirectToCustomPage() {
    this.router.navigate(["custom"]);
  }

  showSubscriptionEssential() {
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
