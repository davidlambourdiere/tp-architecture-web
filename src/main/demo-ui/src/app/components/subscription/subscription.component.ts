import { Component, OnInit } from '@angular/core';

import {SubscriptionDTO} from "../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../service/SubscriptionService";

@Component({
  selector: 'app-subscription',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.scss']
})
export class SubscriptionComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  show: boolean = false;
  name: string = 'all';
  resident : string= '';

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
    this.showSubscription()
  }

  showSubscription() {
    this.route.params.subscribe(params => {
      this.subservice.findAllSubscription().subscribe(data => {
        this.subscriptions = data;

      })
    })
  }




}
