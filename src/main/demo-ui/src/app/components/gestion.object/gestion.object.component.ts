
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

    this.route.params.subscribe(params => {
      this.lightservice.findbyId(1).subscribe(data => {
        this.lights = data, error => console.log(error);
      })
      console.log(this.lights.ipadress);
    })


    this.route.params.subscribe(params => {
      this.heaterservice.findbyId(Number(this.heaters.id)).subscribe(data => {
        this.heaters = data, error => console.log(error);
      })
    })

    this.temperatureactuelle = Number(this.heaters.actualval);



    this.route.params.subscribe(params => {
      this.shutterservice.findbyId(1).subscribe(data => {
        this.shutters = data, error => console.log(error);
      })


      console.log(this.shutters.state);
    })
  }
  onSubmit(form: NgForm) {
    console.log(form.value);
    this.route.params.subscribe(params => {
      this.lightservice.updateLight(Number(this.lights.id), this.lights).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.lights);
    alert(" Done ! ");
  }



  onSubmitShutter(g: NgForm) {
    console.log(g.value);
    this.route.params.subscribe(params => {
      this.shutterservice.updateShutter(Number(this.shutters.id), this.shutters).subscribe(data => console.log(data), error => console.log(error));
    })
    console.log("update"+this.shutters);
   alert(" Done ! ");

  }

  onSubmitHeater(h: NgForm) {
    console.log(h.value);
    this.route.params.subscribe(params => {
      this.heaterservice.updateHeater(Number(this.heaters.id), this.heaters).subscribe(data => console.log(data), error => console.log(error));
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

