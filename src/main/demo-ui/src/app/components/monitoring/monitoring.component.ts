import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IOTService} from '../../service/IOTService';

@Component({
  selector: 'monitoring',
  templateUrl: './monitoring.component.html',
  styleUrls: ['./monitoring.component.scss']
})
export class MonitoringComponent implements OnInit{


  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService){}

  ngOnInit(): void {
    this.findIOTByPerson();
  }

  findAllIOT(){
    this.route.params.subscribe(params=> {
      this.iotservice.findAllIOT().subscribe(data=>{
      })
    })
  }

  findIOTByPerson(){
    this.route.params.subscribe(params=> {
      this.iotservice.findIOTByPerson('1').subscribe(data=>{
      })
    })
  }


}
