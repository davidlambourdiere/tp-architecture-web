import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IOTService} from '../../service/IOTService';
import {IOTDTO} from "../../dto/IOTDTO";

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

  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService) {
  }

  ngOnInit(): void {
    this.findAllIOT();
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
      })
    })
  }

  findByType(){
    this.route.params.subscribe(params => {
      this.iotservice.findIOTByType(this.type).subscribe(data => {
       this.iots = data;
        this.show = true;
      })
    })
  }

  findIOTByPerson(){
    this.route.params.subscribe(params => {
      this.iotservice.findIOTByPerson('1').subscribe(data => {
        this.iots = data;
        this.show = true;
      })
    })
  }

}
