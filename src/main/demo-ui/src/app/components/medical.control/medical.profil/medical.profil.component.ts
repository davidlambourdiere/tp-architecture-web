import { Component, OnInit } from '@angular/core';
import {ALertHealthDTO} from "../../../dto/AlertHealthDTO";
import {HealthHistoricDTO} from "../../../dto/HealthHistoricDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertHealthService} from "../../../service/AlertHealthService";
import {HealthHistoricService} from "../../../service/HealthHistoricService";
import {DatePipe} from "@angular/common";
import {StrapDTO} from "../../../dto/StrapDTO";
import {PersonDTO} from "../../../dto/PersonDTO";
import {RoomDTO} from "../../../dto/RoomDTO";
import {StrapService} from "../../../service/StrapService";

@Component({
  selector: 'app-medical.profil',
  templateUrl: './medical.profil.component.html',
  styleUrls: ['./medical.profil.component.scss']
})
export class MedicalProfilComponent implements OnInit {

  id : bigint;
  strap : StrapDTO;
  historicList : HealthHistoricDTO[];
  dataXlist : Number[];
  dataYlist : string[];
  alertNumber : Number;
  newAlertNumber : Number;
  doneAlertNumber : Number;

  //graph
  public chartType: string = 'line';

  public chartDatasets: Array<any> ;

  public chartLabels: Array<any> ;

  public chartColors: Array<any>;

  public chartOptions: any;

  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }

  constructor(private route: ActivatedRoute, private router: Router,
              private strapService: StrapService,
              private healthHistoricService: HealthHistoricService,
              private datepipe: DatePipe,
              private alertHealthService: AlertHealthService) {
    this.strap = new StrapDTO();
    this.strap.person = new PersonDTO();
    this.strap.room = new RoomDTO();
    this.id = this.route.snapshot.params.id;
    this.historicList = [];
    this.chartType = '';
    this.chartDatasets= [];
    this.chartLabels= [];
    this.chartColors= [];
    this.chartOptions= [];
    this.dataYlist= [];
    this.dataXlist = [];
    this.alertNumber = 0;
  }

  ngOnInit() {
    this.reload();
  }
  async reload() {

    this.route.params.subscribe(params => {
      this.strapService.findById(this.id).subscribe(data => {
        //console.log(data);
        this.strap= data;
        this.findTopByStrap();
        this.findAllFCHistoric();
        this.findAge();
        this.findAlerts();
      }, error => console.log(error));
    });
    this.loadDataChart();
    setTimeout(() => {  this.reload(); }, 3000);
  }

  private findTopByStrap() {
    this.route.params.subscribe(params => {
      this.healthHistoricService.findTopByStrap(this.strap.id).subscribe(data => {
        if (data != null)
          this.strap.hearthrate = data.hearthrate;
        else
          this.strap.hearthrate = 'no data';
      });
    });
  }

  private findAllFCHistoric(){
    this.route.params.subscribe(params =>{
      this.healthHistoricService.findAllByStrap(this.strap.id).subscribe(data=>{
        this.historicList = data;
      });
    });
  }

  private findAlerts(){
    this.route.params.subscribe(params =>{
      this.alertHealthService.findAlertNumberByStrap(this.strap.id).subscribe(data=>{
        this.alertNumber = data;
      });
    });

    this.route.params.subscribe(params =>{
      this.alertHealthService.findNewAlertNumberByStrap(this.strap.id).subscribe(data=>{
        this.newAlertNumber = data;
      });
    });


    this.route.params.subscribe(params =>{
      this.alertHealthService.findDoneAlertNumberByStrap(this.strap.id).subscribe(data=>{
        this.doneAlertNumber = data;
      });
    });

  }

  private findAge(){
    this.strap.person.age  = ''+Math.floor((Math.abs(Date.now() -  new Date(this.strap.person.birthdate).getTime()) / (1000 * 3600 * 24))/365.25);
  }

  private loadDataChart(){
    for (let i = 0; i < this.historicList.length; i++){
      this.dataXlist[i] = Number(this.historicList[i].hearthrate);
      this.dataYlist[i] = ''+this.datepipe.transform(this.historicList[i].startdate, 'h:mm:ss a');
    }


    this.chartType = 'line';

    /*this.chartDatasets = [
      { data: [65, 59, 80, 81, 56, 55, 40], label: 'My First dataset' },
      { data: [28, 48, 40, 19, 86, 27, 90], label: 'My Second dataset' }
    ];*/

    this.chartDatasets  = [
      { data:  this.dataXlist, label: 'Hearthbeat' },
      //{ data: [28, 48, 40, 19, 86, 27, 90], label: 'My Second dataset' }
    ];

    this.chartLabels = this.dataYlist;

    this.chartColors = [
      {
        backgroundColor: 'rgba(105, 0, 132, .2)',
        borderColor: 'rgba(200, 99, 132, .7)',
        borderWidth: 2,
      },
      {
        backgroundColor: 'rgba(0, 137, 132, .2)',
        borderColor: 'rgba(0, 10, 130, .7)',
        borderWidth: 2,
      }
    ];

    this.chartOptions= {
      responsive: true
    };
  }

}
