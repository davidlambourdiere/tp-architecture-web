import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ClockDetailDTO} from "../../../dto/ClockDetailDTO";
import {IOTService} from "../../../service/IOTService";
import {LightDetailDTO} from "../../../dto/LightDetailDTO";
import {HeaterDetailDTO} from "../../../dto/HeaterDetailDTO";
import {ShutterDetailDTO} from "../../../dto/ShutterDetailDTO";
import {StrapDetailDTO} from "../../../dto/StrapDetailDTO";

@Component({
  selector: 'detailiot',
  templateUrl: './detail.iot.component.html',
  styleUrls: ['./detail.iot.component.scss']
})
export class DetailIotComponent implements OnInit {

  id: String;
  state: String;
  clockWithDetail: ClockDetailDTO;
  lightWithDetail: LightDetailDTO;
  heaterWithDetail: HeaterDetailDTO;
  shutterWithDetail: ShutterDetailDTO;
  strapWithDetail: StrapDetailDTO;
  warningOnly: boolean;

  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService) {
    this.warningOnly = false;
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.state = this.route.snapshot.paramMap.get('state');
    this.findDetailAndHistoricForIOT();
  }


  displayOnlyWarningHistoric(): void {
    this.warningOnly = !this.warningOnly;
  }

  findDetailAndHistoricForIOT(): void {
    if(this.state === "Clock"){
      this.route.params.subscribe(params => {
        this.iotservice.findClockDetailWithHistoric(this.route.snapshot.paramMap.get('id')).subscribe(data => {
          this.clockWithDetail = data;
        })
      })
    } else if(this.state === "Light"){
      this.route.params.subscribe(params => {
        this.iotservice.findLightDetailWithHistoric(this.route.snapshot.paramMap.get('id')).subscribe(data => {
          this.lightWithDetail = data;
        })
      })
    } else if(this.state === "Strap"){
      this.route.params.subscribe(params => {
        this.iotservice.findStrapDetailWithHistoric(this.route.snapshot.paramMap.get('id')).subscribe(data => {
          this.strapWithDetail = data;
        })
      })
    }else if(this.state === "Heater"){
      this.route.params.subscribe(params => {
        this.iotservice.findHeaterDetailWithHistoric(this.route.snapshot.paramMap.get('id')).subscribe(data => {
          this.heaterWithDetail = data;
        })
      })
    }else if(this.state === "Shutter"){
      this.route.params.subscribe(params => {
        this.iotservice.findShutterDetailWithHistoric(this.route.snapshot.paramMap.get('id')).subscribe(data => {
          this.shutterWithDetail = data;
        })
      })
    }
  }
}
