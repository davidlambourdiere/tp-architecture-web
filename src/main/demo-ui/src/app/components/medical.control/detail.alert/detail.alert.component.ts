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
import { ChartsModule } from 'ng2-charts/ng2-charts';
@Component({
  selector: 'app-detail.alert',
  templateUrl: './detail.alert.component.html',
  styleUrls: ['./detail.alert.component.scss']
})
export class DetailAlertComponent implements OnInit {
  id : bigint;
  alert : ALertHealthDTO;
  historicList : HealthHistoricDTO[];

  //graph
  public chartType: string = 'line';

  public chartDatasets: Array<any> = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'My First dataset' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'My Second dataset' }
  ];

  public chartLabels: Array<any> = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  public chartColors: Array<any> = [
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

  public chartOptions: any = {
    responsive: true
  };
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }

  constructor(private route: ActivatedRoute, private router: Router,
              private alertHealthService: AlertHealthService,
              private healthHistoricService: HealthHistoricService) {
    this.alert = new ALertHealthDTO();
    this.alert.strap = new StrapDTO();
    this.alert.strap.person = new PersonDTO();
    this.alert.strap.room = new RoomDTO();
    this.id = this.route.snapshot.params.id;
    this.historicList = [];
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
}
