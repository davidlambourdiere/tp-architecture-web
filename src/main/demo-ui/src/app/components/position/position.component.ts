import {Component, OnInit} from '@angular/core';
import {PositionDTO} from "../../dto/PositionDTO";
import {StrapDTO} from "../../dto/StrapDTO";
import {StrapService} from "../../service/StrapService";
import {PositionService} from "../../service/PositionService";

@Component({
  selector: 'app-position',
  templateUrl: './position.component.html',
  styleUrls: ['./position.component.scss']
})
export class PositionComponent implements OnInit {
  position: PositionDTO;
  straps: StrapDTO[] = [];

  constructor(private strapService: StrapService, private positionService: PositionService) {
  }

  ngOnInit() {
    this.findAllStrap();
  }

  findAllStrap(): void {
    this.strapService.findAll().subscribe(straps=>{this.straps = straps; console.log(straps)});

  }

}
