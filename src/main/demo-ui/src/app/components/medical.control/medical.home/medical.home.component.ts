import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ALertHealthDTO} from "../../../dto/AlertHealthDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";
import {PersonService} from "../../../service/PersonService";
import {PersonStatusDTO} from "../../../dto/PersonStatusDTO";


@Component({
  selector: 'app-medicalhome',
  templateUrl: './medical.home.component.html',
  styleUrls: ['./medical.home.component.scss']
})
export class MedicalHomeComponent implements OnInit {

  alertHealthlList: ALertHealthDTO[]= [];
  residentNumber: Number;
  doctorNumber: Number;
  agentNumber: Number;

  constructor(private alertHealthService: AlertHealthService, private router: Router, private route: ActivatedRoute, private personService: PersonService) {
  this.alertHealthlList = [];
  this.residentNumber =0;
  this.doctorNumber=0;
  this.agentNumber=0;
  }

  ngOnInit() {
    this.reloadData();
    this.findResidentNumber();
    this.findDoctorNumber();
    this.findAgentNumber();
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
      this.personService.findNumberOfPersonByRole(PersonStatusDTO.RESIDENT).subscribe(data=>{
        this.residentNumber = data;
      });
    });
  }
  private findDoctorNumber() {
    this.route.params.subscribe(params =>{
      this.personService.findNumberOfPersonByRole(PersonStatusDTO.DOCTOR).subscribe(data=>{
        this.doctorNumber = data;
      });
    });
  }

  private findAgentNumber() {
    this.route.params.subscribe(params =>{
      this.personService.findNumberOfPersonByRole(PersonStatusDTO.AGENT).subscribe(data=>{
        this.agentNumber = data;
      });
    });
  }
}
