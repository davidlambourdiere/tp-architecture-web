import {Component, OnInit} from '@angular/core';
import {PersonService} from "../../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {PersonDTO} from "../../../dto/PersonDTO";
import {PersonStatusDTO} from "../../../dto/PersonStatusDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";
import {StrapService} from "../../../service/StrapService";
import {StrapDTO} from "../../../dto/StrapDTO";
import {HealthHistoricService} from "../../../service/HealthHistoricService";
import {HealthHistoricDTO} from "../../../dto/HealthHistoricDTO";
import { FormControl } from "@angular/forms";

@Component({
  selector: 'app-medicalresidents',
  templateUrl: './medical.residents.component.html',
  styleUrls: ['./medical.residents.component.scss']
})
export class MedicalResidentsComponent implements OnInit {
  personlist: PersonDTO[];
  straplist: StrapDTO[];
  residentNumber: Number;
  newAlertsNumber: Number;
  results: any[] = [];
  queryField: FormControl = new FormControl();


  constructor(private personService: PersonService,
              private strapService: StrapService,
              private router: Router,
              private route: ActivatedRoute,
              private alertHealthService: AlertHealthService,
              private healthHistoricService: HealthHistoricService) {
    this.residentNumber =0;
    this.newAlertsNumber=0;
    this.straplist = [];
  }

  ngOnInit() {
    this.reloadData();
    this.queryField.valueChanges.subscribe( result => console.log(result));
  }


  async reloadData() {
    // @ts-ignore
    this.findAllStraps();
    this.findTopByStrap();
    this.findNewAlertsNumber();
    this.findResidentNumber();
    //console.log('refresh-resident');
    setTimeout(() => {  this.reloadData(); }, 3000);
  }

  private findAllStraps() {
    this.route.params.subscribe(params =>{
      this.strapService.findAll().subscribe(data=>{
        this.straplist = data;
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

  private findTopByStrap() {
    for (let i = 0; i < this.straplist.length; i++){
      this.route.params.subscribe(params =>{
        this.healthHistoricService.findTopByStrap(this.straplist[i].id).subscribe(data=>{
          if (data != null)
            this.straplist[i].hearthrate = data.hearthrate;
          else
            this.straplist[i].hearthrate = 'no data';
        });
      });
    }

  }


}
