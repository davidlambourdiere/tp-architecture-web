import {Component, Input} from "@angular/core";
import {forEachComment} from "tslint";

@Component({
  selector: 'panne',
  templateUrl: './panne.component.html',
  styleUrls: ['./panne.component.scss']
})
export class PanneComponent {
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

  constructor(){
    this.breakdownLogement();
  }

}
