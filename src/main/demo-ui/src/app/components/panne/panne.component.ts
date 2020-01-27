import {Component, Input} from "@angular/core";
import {forEachComment} from "tslint";
import {ActivatedRoute, Router} from "@angular/router";
import {IOTService} from "../../service/IOTService";
import {IOTDTO} from "../../dto/IOTDTO";
import {ClockDTO} from "../../dto/ClockDTO";



@Component({
  selector: 'panne',
  templateUrl: './panne.component.html',
  styleUrls: ['./panne.component.scss']
})
export class PanneComponent {
  iots: IOTDTO = new IOTDTO;
  RoomBreakdown : number = 0;

  logements = [
    {
      num: 1,
      breakdown: 0
    },
    {
      num: 2,
      breakdown: 0
    },
    {
      num: 4,
      breakdown: 0
    },
    {
      num: 5,
      breakdown: 0
    },
    {
      num: 6,
      breakdown: 0
    },
    {
      num: 7,
      breakdown: 0
    },
    {
      num: 8,
      breakdown: 0
    },
    {
      num: 9,
      breakdown: 0
    },
  ];

  objects = [
    {
      type: 'Lumière',
      status: 'Fonctionnel',
      logement: 1

    },
    {
      type: 'Four',
      status: 'Fonctionnel',
      logement: 1

    },
    {
      type: 'Volet',
      status: 'En panne',
      logement: 1

    },
  ];

  //Define the number of object in breakdown in a housing
  breakdownLogement(){
    for (let logement of this.logements){
      for (let object of this.objects){
        if(object.logement == logement.num){
          if(object.status == 'En panne'){
            logement.breakdown = logement.breakdown+1;
          }
        }
      }
    }


  }

  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService){
    this.breakdownLogement();
  }

  findIOTByPerson(){
    this.route.params.subscribe(params => {
      this.iotservice.findIOTByPerson('1').subscribe(data => {
        this.iots = data;
        const states = Object.values(this.iots)
            .filter(Boolean)
            .reduce((res, value) => res.concat(value.map(ot => ({id:ot.id, state: ot.state}))), [])
          .filter(iot => iot.state !== "ok");
        console.log(states);

      })
    })
  }



}
