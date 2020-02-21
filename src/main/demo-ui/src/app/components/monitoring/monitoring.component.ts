import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IOTService} from '../../service/IOTService';
import {IOTDTO} from "../../dto/IOTDTO";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'monitoring',
  templateUrl: './monitoring.component.html',
  styleUrls: ['./monitoring.component.scss']
})
export class MonitoringComponent implements OnInit {

  iots: IOTDTO = new IOTDTO;
  show: boolean = false;
  type: string = 'all';
  owner: string= '';
  iotToReturn: string;

  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService) {
    console.log('construct');
    this.iotToReturn = 'alliot';
  }

  ngOnInit(): void {
    console.log(this.iotToReturn);
    if(this.iotToReturn==='alliot'){
      this.findAllIOT();
    } else if (this.iotToReturn==='iotmalfunctionning'){
      this.findAllIOTWithMalfunctionning();
    }
  }

  findAllIOT() {
    this.route.params.subscribe(params => {
      this.iotservice.findAllIOT().subscribe(data => {
        this.iots = data;
        this.show = true;
      })
    })
  }

  findAllIOTWithMalfunctionning(){
    this.route.params.subscribe(params => {
      this.iotservice.findAllIOTWithMalfunctionning().subscribe(data => {
        this.iots = data;
        this.show = true;
        this.iotToReturn = 'iotmalfunctionning';
      })
    })
  }

}
