import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MockIOTAndServiceService} from "../../service/MockIOTAndServiceService";
import {ExtraCostDTO} from "../../dto/ExtraCostDTO";

@Component({
  selector: 'app-mock.billing',
  templateUrl: './mock.billing.component.html',
  styleUrls: ['./mock.billing.component.scss']
})
export class MockBillingComponent implements OnInit {

  extraCostList: Array<ExtraCostDTO>;

  constructor(private router: Router, private route: ActivatedRoute, private mockIOTAndService: MockIOTAndServiceService) { }

  ngOnInit() {

  }

  startMockingBilling() {
    this.route.params.subscribe(params => {
      this.mockIOTAndService.startMock().subscribe((data: Array<ExtraCostDTO>) => {
        this.extraCostList = data;
      });
    });
  }
}
