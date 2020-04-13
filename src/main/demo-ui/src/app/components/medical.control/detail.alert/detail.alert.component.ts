import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StrapDTO} from "../../../dto/StrapDTO";
import {StrapService} from "../../../service/StrapService";
import {PersonDTO} from "../../../dto/PersonDTO";
import {RoomDTO} from "../../../dto/RoomDTO";

@Component({
  selector: 'app-detail.alert',
  templateUrl: './detail.alert.component.html',
  styleUrls: ['./detail.alert.component.scss']
})
export class DetailAlertComponent implements OnInit {
  id: number;
  strap : StrapDTO;
  constructor(private route: ActivatedRoute, private router: Router,
              private strapService: StrapService) { }

  ngOnInit() {
    this.strap = new StrapDTO();
    this.strap.person = new PersonDTO();
    this.strap.room = new RoomDTO();
    this.id = this.route.snapshot.params.id;

    this.route.params.subscribe(params => {
      this.strapService.findById(this.id).subscribe(data => {
        this.strap = data;
      });
    });


  }

}
