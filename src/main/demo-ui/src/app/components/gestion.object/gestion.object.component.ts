
import {Component, OnInit} from '@angular/core';
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/AuthService";
// @ts-ignore
import {HeaterService} from "../../service/HeaterService";
import {HeaterDTO} from "../../dto/HeaterDTO";
import {NgForm} from "@angular/forms";
import {LightService} from "../../service/LightService";
import {LightDTO} from "../../dto/LightDTO";



@Component({
  selector: 'gestion-object',
  templateUrl: './gestion.object.component.html',
  styleUrls: ['./gestion.object.component.scss']
})



export class GestionObjectComponent implements OnInit {
  heaters: HeaterDTO = new HeaterDTO();
  lights: LightDTO ;

  defaultOnOff = 'éteint';
  defaultIntensite ='moyenne';
  defaultCouleur ='bleu';

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private heaterService: HeaterService, private lightservice: LightService) {
  }

  ngOnInit(): void {
    this.showHeater();
    this.lights = new LightDTO();


    this.route.params.subscribe(params => {
      this.lightservice.findbyId(1).subscribe(data => {
        this.lights = data, error => console.log(error);
      })
      console.log(this.lights.ipadress);
    })

  }
  onSubmit(form: NgForm) {
    console.log(form.value);
     // const name = form.value['name'];
     // const status = form.value['status'];
    this.route.params.subscribe(params => {
      this.lightservice.updateLight(1, this.lights).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.lights);

  }



  showHeater() {
    this.route.params.subscribe(params => {
      this.heaterService.findAllHeater().subscribe(data => {
        this.heaters = data;

      })
    })


  }
}
