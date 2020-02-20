import { Component, OnInit } from '@angular/core';
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";

@Component({
  selector: 'app-essential',
  templateUrl: './essential.component.html',
  styleUrls: ['./essential.component.scss']
})
export class EssentialComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;


  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
   // this.name = this.route.snapshot.paramMap.get('name');
  this.name = 'essential';
  console.log(JSON.stringify(this.name));
    this.showSubscriptionEssential();
  }

  showSubscriptionEssential() {
    this.route.params.subscribe(params => {
      this.subservice.findSubscriptionByProfile(this.name).subscribe(data => {
        this.subscriptions = data;

      });
    });
  }
}
