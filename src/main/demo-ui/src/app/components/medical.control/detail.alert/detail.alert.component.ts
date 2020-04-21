import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StrapDTO} from "../../../dto/StrapDTO";
import {StrapService} from "../../../service/StrapService";
import {PersonDTO} from "../../../dto/PersonDTO";
import {RoomDTO} from "../../../dto/RoomDTO";
import {ALertHealthDTO} from "../../../dto/AlertHealthDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";
import {HealthHistoricService} from "../../../service/HealthHistoricService";
import {HealthHistoricDTO} from "../../../dto/HealthHistoricDTO";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-detail.alert',
  templateUrl: './detail.alert.component.html',
  styleUrls: ['./detail.alert.component.scss']
})
export class DetailAlertComponent implements OnInit {
  id : bigint;
  alert : ALertHealthDTO;
  historicList : HealthHistoricDTO[];
  dataXlist : Number[];
  dataYlist : string[];
  //graph
  public chartType: string = 'line';

  public chartDatasets: Array<any> ;

  public chartLabels: Array<any> ;

  public chartColors: Array<any>;

  public chartOptions: any;

  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }

  constructor(private route: ActivatedRoute, private router: Router,
              private alertHealthService: AlertHealthService,
              private healthHistoricService: HealthHistoricService,
              private datepipe: DatePipe) {
    this.alert = new ALertHealthDTO();
    this.alert.strap = new StrapDTO();
    this.alert.strap.person = new PersonDTO();
    this.alert.strap.room = new RoomDTO();
    this.id = this.route.snapshot.params.id;
    this.historicList = [];

    this.chartType = '';

    this.chartDatasets= [];

    this.chartLabels= [];

    this.chartColors= [];

    this.chartOptions= [];

    this.dataYlist= [];
    this.dataXlist = [];
  }

  ngOnInit() {
    this.reload();
  }
  async reload() {

    this.route.params.subscribe(params => {
      this.alertHealthService.findById(this.id).subscribe(data => {
        //console.log(data);
        this.alert = data;
        this.findTopByStrap();
        this.findAllFCHistoric();
      }, error => console.log(error));
    });
    this.loadDataChart();
    setTimeout(() => {  this.reload(); }, 3000);
  }

  private findTopByStrap() {
    this.route.params.subscribe(params => {
      this.healthHistoricService.findTopByStrap(this.alert.strap.id).subscribe(data => {
        if (data != null)
          this.alert.strap.hearthrate = data.hearthrate;
        else
          this.alert.strap.hearthrate = 'no data';
      });
    });
  }

  private findAllFCHistoric(){
    this.route.params.subscribe(params =>{
      this.healthHistoricService.findAllByStrap(this.alert.strap.id).subscribe(data=>{
        this.historicList = data;
      });
    });
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
      { data:  this.dataXlist, label: 'My First dataset' },
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
