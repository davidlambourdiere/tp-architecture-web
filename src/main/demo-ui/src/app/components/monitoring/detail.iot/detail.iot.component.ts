import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ClockDetailDTO} from "../../../dto/ClockDetailDTO";
import {IOTService} from "../../../service/IOTService";

@Component({
  selector: 'detailiot',
  templateUrl: './detail.iot.component.html',
  styleUrls: ['./detail.iot.component.scss']
})
export class DetailIotComponent implements OnInit {

  id: String;
  state: String;
  clockWithDetail: ClockDetailDTO;

  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.state = this.route.snapshot.paramMap.get('state');
    this.route.params.subscribe(params => {
      this.iotservice.findClockDetailWithHistoric(this.route.snapshot.paramMap.get('id')).subscribe(data => {
        this.clockWithDetail = data;
      })
    })
  }
}
