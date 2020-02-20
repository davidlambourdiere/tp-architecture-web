import { Component, OnInit } from '@angular/core';
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";

@Component({
  selector: 'app-serenity',
  templateUrl: './serenity.component.html',
  styleUrls: ['./serenity.component.scss']
})
export class SerenityComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
    this.name = 'serenity';
    console.log(JSON.stringify(this.name));
    this.showSubscriptionSerenity();
  }

  showSubscriptionSerenity() {
    this.route.params.subscribe(params => {
      this.subservice.findSubscriptionByProfile(this.name).subscribe(data => {
        this.subscriptions = data;

      });
    });
  }
}
