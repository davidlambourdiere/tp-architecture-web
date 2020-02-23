import { Component, OnInit } from '@angular/core';
import {PersonService} from "../../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {PersonDTO} from "../../../dto/PersonDTO";
import {Observable} from "rxjs";
import {PersonStatusDTO} from "../../../dto/PersonStatusDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";

@Component({
  selector: 'app-medicalresidents',
  templateUrl: './medical.residents.component.html',
  styleUrls: ['./medical.residents.component.scss']
})
export class MedicalResidentsComponent implements OnInit {
  personlist: PersonDTO[];
  residentNumber: Number;
  newAlertsNumber: Number;

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private alertHealthService: AlertHealthService,) {
    this.residentNumber =0;
    this.newAlertsNumber=0;
  }

  ngOnInit() {
    this.reloadData();

  }


  reloadData() {
    // @ts-ignore
    this.personlist = this.findAllPeron();
    this.findNewAlertsNumber();
    this.findResidentNumber();
  }

  private findAllPeron() {
    this.route.params.subscribe(params =>{
      this.personService.findAllPerson().subscribe(data=>{
        this.personlist = data;
      });
    });
  }

  private findResidentNumber() {
    this.route.params.subscribe(params =>{
      this.personService.findNumberOfPersonByRole(PersonStatusDTO.RESIDENT).subscribe(data=>{
        this.residentNumber = data;
      });
    });
  }

  private findNewAlertsNumber() {
//alertNumber
    this.route.params.subscribe(params =>{
      this.alertHealthService.findAlertNumber().subscribe(data=>{
        this.newAlertsNumber = data;
      });
    });
  }
}
