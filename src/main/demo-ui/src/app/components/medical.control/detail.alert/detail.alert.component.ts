import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StrapDTO} from "../../../dto/StrapDTO";
import {StrapService} from "../../../service/StrapService";
import {PersonDTO} from "../../../dto/PersonDTO";
import {RoomDTO} from "../../../dto/RoomDTO";
import {ALertHealthDTO} from "../../../dto/AlertHealthDTO";
import {AlertHealthService} from "../../../service/AlertHealthService";
import {HealthHistoricService} from "../../../service/HealthHistoricService";
import {HealthHistoricDTO} from "../../../dto/HealthHistoricDTO";

@Component({
  selector: 'app-detail.alert',
  templateUrl: './detail.alert.component.html',
  styleUrls: ['./detail.alert.component.scss']
})
export class DetailAlertComponent implements OnInit {
  id: number;
  alert : ALertHealthDTO;
  historicList : HealthHistoricDTO[];

  constructor(private route: ActivatedRoute, private router: Router,
              private alertHealthService: AlertHealthService,
              private healthHistoricService: HealthHistoricService) {

  }

  ngOnInit() {
    this.alert = new ALertHealthDTO();
    this.alert.strap = new StrapDTO();
    this.alert.strap.person = new PersonDTO();
    this.alert.strap.room = new RoomDTO();
    this.id = this.route.snapshot.params.id;
    this.historicList = [];

    this.route.params.subscribe(params => {
      this.alertHealthService.findById(this.id).subscribe(data => {
        this.alert = data;
      });
    });console.log(this.alert.message);
    //this.findTopByStrap();


  }

  private findTopByStrap() {
    this.route.params.subscribe(params => {
      this.healthHistoricService.findTopByStrap(this.alert.strap.id).subscribe(data => {
        if (data != null)
          this.alert.strap.hearthrate = data.hearthrate;
        else
          this.alert.strap.hearthrate = 'no data';
      });
    });
  }

}
