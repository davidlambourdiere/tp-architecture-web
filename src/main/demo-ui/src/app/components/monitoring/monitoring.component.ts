import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IOTDTO} from '../../dto/IOTDTO';
import {IOTService} from '../../service/IOTService';

@Component({
  selector: 'monitoring',
  templateUrl: './monitoring.component.html',
  styleUrls: ['./monitoring.component.scss']
})
export class MonitoringComponent implements OnInit{

  iots: IOTDTO[] = [];

  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService){}

  ngOnInit(): void {
    this.findAllIOT();
  }

  findAllIOT(){
    this.route.params.subscribe(params=> {
      this.iotservice.findAllIOT().subscribe(data=>{
        this.iots = data;
      })
    })
  }


}
