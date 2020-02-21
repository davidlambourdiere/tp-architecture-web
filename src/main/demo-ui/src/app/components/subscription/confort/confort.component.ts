import { Component, OnInit } from '@angular/core';
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";

@Component({
  selector: 'app-confort',
  templateUrl: './confort.component.html',
  styleUrls: ['./confort.component.scss']
})
export class ConfortComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) {
  }

  ngOnInit() {
    this.name = 'confort';
    console.log(JSON.stringify(this.name));
    this.showSubscriptionConfort();
  }

  validate(){
    this.router.navigate(["home"]);
  }

  redirectToCustomPage(){
    this.router.navigate(["custom"]);
  }

  showSubscriptionConfort() {
    this.route.params.subscribe(params => {
      this.subservice.findSubscriptionByProfile(this.name).subscribe(data => {
        this.subscriptions = data;

      })
    })
  }

}

