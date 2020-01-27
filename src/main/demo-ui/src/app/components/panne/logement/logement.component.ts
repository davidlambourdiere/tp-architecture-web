import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-logement',
  templateUrl: './logement.component.html',
  styleUrls: ['./logement.component.scss']
})
export class LogementComponent implements OnInit {
  @Input() IOTNum : number;
  @Input() IOTBreakdown : number;

  constructor() { }

  ngOnInit() {
  }



  onList (){
    console.log("Youp");
  }

  //define the color of the housing
  //If the housing is upper than 0 then the housing is in red
  //Else the housing is in green
  getColor() {
    if(this.IOTBreakdown > 0) {
      return "red";
    } else {
      return "green";
    }
  }
}
