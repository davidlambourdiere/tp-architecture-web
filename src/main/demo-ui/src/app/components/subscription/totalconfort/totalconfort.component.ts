import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionService} from "../../../service/SubscriptionService";
import {SubscriptionDTO} from "../../../dto/SubscriptionDTO";
import {SubscriptionResidentDTO} from "../../../dto/SubscriptionResidentDTO";

@Component({
  selector: 'app-totalconfort',
  templateUrl: './totalconfort.component.html',
  styleUrls: ['./totalconfort.component.scss']
})
export class TotalconfortComponent implements OnInit {
  subscriptions: SubscriptionDTO = new SubscriptionDTO();
  name: string;
  login: string;
  residentSubscriptionDTO: SubscriptionResidentDTO;

  constructor(private router: Router, private route: ActivatedRoute, private subservice: SubscriptionService) { }

  ngOnInit() {
    this.name = 'total-confort';
    console.log(JSON.stringify(this.name));
    this.showSubscriptionTotalConfort();
    this.login = this.route.snapshot.paramMap.get('login');
  }

  validate() {
    this.router.navigate(['home']);
  }

  redirectToCustomPage() {
    this.router.navigate(['custom']);
  }

  showSubscriptionTotalConfort() {
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
