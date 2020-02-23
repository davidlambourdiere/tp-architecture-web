import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ALertHealthDTO} from "../../../dto/AlertHealthDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";


@Component({
  selector: 'app-medicalhome',
  templateUrl: './medical.home.component.html',
  styleUrls: ['./medical.home.component.scss']
})
export class MedicalHomeComponent implements OnInit {

  alertHealthlList: ALertHealthDTO[];
  constructor(private alertHealthService: AlertHealthService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    // @ts-ignore
    alertHealthlList = this.findNewAlerts()();
  }

  private findNewAlerts() {
    this.route.params.subscribe(params =>{
      this.alertHealthService.findNewAlerts().subscribe(data=>{
        this.alertHealthlList = data;
      });
    });
  }

}
