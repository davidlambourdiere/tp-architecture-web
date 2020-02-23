import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ALertHealthDTO} from "../../../dto/AlertHealthDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";
import {PersonService} from "../../../service/PersonService";
import {ActivityAnalysisDTO} from "../../../dto/ActivityAnalysisDTO";


@Component({
  selector: 'app-medicalhome',
  templateUrl: './medical.home.component.html',
  styleUrls: ['./medical.home.component.scss']
})
export class MedicalHomeComponent implements OnInit {

  alertHealthlList: ALertHealthDTO[]= [];
  residentNumber: Number;
  constructor(private alertHealthService: AlertHealthService, private router: Router, private route: ActivatedRoute, private personService: PersonService) {
  this.alertHealthlList = [];
  }

  ngOnInit() {
    this.reloadData();
    this.findResidentNumber();
  }

  reloadData() {
    // @ts-ignore
    this.alertHealthlList = this.findNewAlerts();
  }

  private findNewAlerts() {
    this.alertHealthlList = [];
    this.route.params.subscribe(params =>{
      this.alertHealthService.findNewAlerts().subscribe(data=>{
        this.alertHealthlList = data;
      });
    });
  }

  private findResidentNumber() {
    this.route.params.subscribe(params =>{
      this.personService.findResidentNumber().subscribe(data=>{
        this.residentNumber = data;
      });
    });
  }

}
