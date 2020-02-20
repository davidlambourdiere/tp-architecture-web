import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";

@Component({
  selector: 'app-totalconfort',
  templateUrl: './totalconfort.component.html',
  styleUrls: ['./totalconfort.component.scss']
})
export class TotalconfortComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
    this.name = 'totalconfort';
    console.log(JSON.stringify(this.name));
    this.showSubscriptionTotalConfort();
  }

  showSubscriptionTotalConfort() {
    this.route.params.subscribe(params => {
      this.subservice.findSubscriptionByProfile(this.name).subscribe(data => {
        this.subscriptions = data;

      });
    });
  }

}
