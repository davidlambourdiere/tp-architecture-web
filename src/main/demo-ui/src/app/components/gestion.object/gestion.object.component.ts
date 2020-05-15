
import {Component, OnInit} from '@angular/core';
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/AuthService";
// @ts-ignore
import {HeaterService} from "../../service/HeaterService";
import {HeaterDTO} from "../../dto/HeaterDTO";
import {NgForm} from "@angular/forms";
import {LightService} from "../../service/LightService";
import {LightDTO} from "../../dto/LightDTO";
import {ShutterDTO} from "../../dto/ShutterDTO";
import {ShutterService} from "../../service/ShutterService";
import {$} from "protractor";
import {IOTDTO} from "../../dto/IOTDTO";
import {IOTService} from "../../service/IOTService";



@Component({
  selector: 'gestion-object',
  templateUrl: './gestion.object.component.html',
  styleUrls: ['./gestion.object.component.scss']

})



export class GestionObjectComponent implements OnInit {
  heaters: HeaterDTO ;
  lights: LightDTO ;
  shutters: ShutterDTO ;
  owner: string= '';
  type: string = 'all';
  iots:  IOTDTO;
  show: boolean = false;
  id: string= '';
  temperatureactuelle : number ;
  heurePrevue: Date;

  defaultOnOff = 'éteint';
  defaultIntensite ='50';
  defaultCouleur ='bleu';

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private heaterservice: HeaterService, private lightservice: LightService, private shutterservice : ShutterService, private iotservice: IOTService) {
  }

  ngOnInit(): void {

    this.findAllIOT();
    this.lights = new LightDTO();
    this.shutters = new ShutterDTO();
    this.heaters = new HeaterDTO();
    this.iots = new IOTDTO();

    console.log(this.heaters.actualval);
    console.log(this.shutters);
    console.log(this.lights);
    console.log(this.heaters);



    this.setHourScenario();
    this.verrifyHour();


    this.temperatureactuelle = Number(this.heaters.actualval);




  }
  onSubmit(form: NgForm) {
    console.log(form.value);
    this.route.params.subscribe(params => {
      this.lightservice.updateLight(this.lights.id, this.lights).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.lights);
    alert(" Done ! ");
  }



  onSubmitShutter(g: NgForm) {
    console.log(g.value);
    this.route.params.subscribe(params => {
      this.shutterservice.updateShutter(this.shutters.id, this.shutters).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.shutters);
   alert(" Done ! ");

  }

  onSubmitHeater(h: NgForm) {
    console.log(h.value);
    this.route.params.subscribe(params => {
      this.heaterservice.updateHeater(this.heaters.id, this.heaters).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.heaters);
    alert(" Done ! ");

  }

SwitchDownHeat(){

     this.temperatureactuelle = Number("400");
      this.temperatureactuelle = this.temperatureactuelle -1;
      console.log('La température baisse')
      console.log('La température est maintenant de '  + this.temperatureactuelle)


}


  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }

  findAllIOT() {
    this.route.params.subscribe(params => {
      this.iotservice.findAllIOT().subscribe(data => {
        this.iots = data;
        this.show = true;
      })
    })
  }

  setHourScenario(){
    this.heurePrevue = new Date();
    this.heurePrevue.setHours(10);
    this.heurePrevue.setMinutes(48);
    this.heurePrevue.setSeconds(0);
    this.heurePrevue.setMilliseconds(0);
  }

  async verrifyHour() {

    setTimeout(() => {
      var heurePC = new Date();
      if (this.heurePrevue.getHours() == heurePC.getHours() && this.heurePrevue.getMinutes() == heurePC.getMinutes()){
        console.log("TEEEEEEEEEEEEEEEEEST"+ new Date());
        this.runScenario();
    }
      }, 1000);
  }

runScenario(){
  for (let i = 0; i < this.iots.shutters.length; i++) {
    this.runScenarioShutter(this.iots.shutters[i]);
  }
  for (let i = 0; i < this.iots.lights.length; i++) {
    this.runScenarioLight(this.iots.lights[i]);
  }
  for (let i = 0; i < this.iots.heaters.length; i++) {
    this.runScenarioHeater(this.iots.heaters[i]);
  }
}

  async runScenarioShutter(shutters : ShutterDTO){


    var resultatShutter= Number(shutters.percentage) ;

    setTimeout(() => {
      // Do something before delay
      if ( resultatShutter >0){
        this.runScenarioShutter(shutters);
      }

    }, 5000);
    resultatShutter = resultatShutter - 1;

    this.shutters.percentage = resultatShutter.toString();

    console.log('Le store se baisse ');
    console.log(resultatShutter);




    shutters.percentage = resultatShutter.toString();


      this.route.params.subscribe(params => {
        this.shutterservice.updateShutter(shutters.id, shutters).subscribe(data => console.log(data), error => console.log(error));
        console.log("update"+shutters);
      });




  }

  async runScenarioLight(lights : LightDTO){

    var resultat= Number(lights.percentage) ;

    setTimeout(() => {
      // Do something before delay
      if (resultat >0){
        this.runScenarioLight(lights);
      }

    }, 5000);

    resultat = resultat - 1;

    lights.percentage = resultat.toString();

    console.log('La luminosité baisse ');
    console.log(resultat);






    this.lights.percentage = resultat.toString();
      this.route.params.subscribe(params => {
        this.lightservice.updateLight(lights.id, lights).subscribe(data => console.log(data), error => console.log(error));
        console.log("update"+lights);
      });


    // Do something after
    //console.log('Fin, luminosité à 0')



  }


  async runScenarioHeater(heaters : HeaterDTO){

    var resultatHeater= Number(heaters.actualval) ;

    setTimeout(() => {
      // Do something before delay
      if (resultatHeater >22){
        this.runScenarioHeater(heaters);
      }

    }, 5000);

    resultatHeater = resultatHeater - 1;

    heaters.actualval = resultatHeater.toString();

    console.log('La température du chauffage se stabilise à une valeur correcte ');
    console.log(resultatHeater);






    this.heaters.actualval = resultatHeater.toString();
    this.route.params.subscribe(params => {
      this.heaterservice.updateHeater(heaters.id, heaters).subscribe(data => console.log(data), error => console.log(error));
      console.log("update"+heaters);
    });


    // Do something after
    //console.log('Fin, luminosité à 0')



  }
}

