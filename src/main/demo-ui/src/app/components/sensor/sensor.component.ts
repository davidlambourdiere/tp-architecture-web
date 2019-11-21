import { Component, OnInit } from '@angular/core';
import {SensorDTO} from "../../dto/SensorDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {SensorService} from "../../service/SensorService";

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.scss']
})
export class SensorComponent implements OnInit {

  sensors: SensorDTO[]= [];

  constructor( private router: Router, private route: ActivatedRoute, private sensorService: SensorService) { }

  ngOnInit() {
    this.route.params.subscribe(params=> {
      this.sensorService.findAllSensors().subscribe(data=>{
        this.sensors = data;
      })
    })
  }

}
