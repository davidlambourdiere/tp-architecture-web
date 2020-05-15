import { Component, OnInit } from '@angular/core';

import {SubscriptionDTO} from "../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../service/SubscriptionService";

@Component({
  selector: 'app-subscription',
  templateUrl: './custom.component.html',
  styleUrls: ['./custom.component.scss']
})
export class CustomComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  show: boolean = false;
  name: string = 'all';
  resident : string= '';

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {

  }

  redirectToHomePage(){
    this.router.navigate(["home"]);
  }

}
