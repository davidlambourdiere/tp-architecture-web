
import {Component, OnInit} from '@angular/core';
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/AuthService";
// @ts-ignore
import {HeaterService} from "../../service/HeaterService";
import {HeaterDTO} from "../../dto/HeaterDTO";



@Component({
  selector: 'gestion-object',
  templateUrl: './gestion.object.component.html',
  styleUrls: ['./gestion.object.component.scss']
})



export class GestionObjectComponent implements OnInit {
  heaters: HeaterDTO = new HeaterDTO();


  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private heaterService: HeaterService) {
  }

  ngOnInit(): void {
    this.showHeater();
  }

  showHeater() {
    this.route.params.subscribe(params => {
      this.heaterService.findAllHeater().subscribe(data => {
        this.heaters = data;

      })
    })


  }
}
