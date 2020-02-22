
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



@Component({
  selector: 'gestion-object',
  templateUrl: './gestion.object.component.html',
  styleUrls: ['./gestion.object.component.scss']
})



export class GestionObjectComponent implements OnInit {
  heaters: HeaterDTO = new HeaterDTO();
  lights: LightDTO ;
  shutters: ShutterDTO ;

  defaultOnOff = 'éteint';
  defaultIntensite ='50';
  defaultCouleur ='bleu';

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private heaterService: HeaterService, private lightservice: LightService, private shutterservice : ShutterService) {
  }

  ngOnInit(): void {

    this.lights = new LightDTO();
    this.shutters = new ShutterDTO();

    console.log(this.shutters);
    console.log(this.lights);

    this.route.params.subscribe(params => {
      this.lightservice.findbyId(1).subscribe(data => {
        this.lights = data, error => console.log(error);
      })
      console.log(this.lights.ipadress);
    })

    this.route.params.subscribe(params => {
      this.shutterservice.findbyId(1).subscribe(data => {
        this.shutters = data, error => console.log(error);
      })
      console.log("coucou");
      console.log(this.shutters.state);
    })
  }
  onSubmit(form: NgForm) {
    console.log(form.value);
    this.route.params.subscribe(params => {
      this.lightservice.updateLight(1, this.lights).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.lights);
  }



  onSubmitShutter(g: NgForm) {
    console.log(g.value);
    this.route.params.subscribe(params => {
      this.shutterservice.updateShutter(1, this.shutters).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.shutters);


  }






  delay(ms: number) {
    return new Promise( resolve => setTimeout(resolve, ms) );
  }

  runScenario(){

    var resultat= Number(this.lights.percentage) ;
    var resultatShutter= Number(this.shutters.percentage) ;
    console.time ("truc");

    resultat = resultat - (resultat/2);
    resultatShutter = resultatShutter - (resultatShutter/2);
    this.lights.percentage = resultat.toString();
    this.shutters.percentage = resultatShutter.toString();

     (async () => {

        // Do something before delay
       console.log('La luminosité baisse ')
       console.log(resultat)
       console.log('Le store se baisse ')
       console.log(resultatShutter)
        await this.delay(20000);
      })();

resultat =0;
resultatShutter =0;
    this.lights.percentage = resultat.toString();
    this.shutters.percentage = resultatShutter.toString();

    (async () => {
      this.route.params.subscribe(params => {
        this.lightservice.updateLight(1, this.lights).subscribe(data => console.log(data), error => console.log(error));
        console.log("update"+this.lights);
      })
      this.route.params.subscribe(params => {
        this.shutterservice.updateShutter(1, this.shutters).subscribe(data => console.log(data), error => console.log(error));
        console.log("update"+this.shutters);
      })
      await this.delay(20000);

      // Do something after
      console.log('Fin, luminosité à 0')
      console.log('Fin, shutter à 0')
    })();

    console.timeEnd("truc");



  }


}

