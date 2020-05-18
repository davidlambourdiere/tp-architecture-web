import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {BillingService} from "../../service/BillingService";
import {PersonDTO} from "../../dto/PersonDTO";

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.scss']
})
export class BillingComponent implements OnInit {
  login: string;
  file: Blob;
  fileURL: string;


  constructor(private router: Router, private route: ActivatedRoute, private billingService: BillingService) {
  }

  ngOnInit() {
    this.login = this.route.snapshot.paramMap.get('login');
  }

  billingReport() {

    this.route.params.subscribe(params => {
      this.billingService.billingReport(this.login).subscribe((data: ArrayBuffer)  => {
        this.file = new Blob([data], {type: 'application/pdf'});
        this.fileURL = URL.createObjectURL(this.file);
        window.open(this.fileURL);
      });
    });
  }
}
