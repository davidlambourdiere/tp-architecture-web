import {Component, OnInit} from "@angular/core";
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {HeaterService} from "../../../service/HeaterService";
import {LightDTO} from "../../../dto/LightDTO";
import {LightService} from "../../../service/LightService";

@Component({
  selector: 'notification/light',
  templateUrl: './notification.light.component.html',
  styleUrls: ['./notification.light.component.scss']
})
export class NotificationLightComponent implements OnInit{

  id: string;
  light: LightDTO;

  constructor(private router: Router, private route: ActivatedRoute, private lightService: LightService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findLight();
  }

  findLight(): void{
    this.route.params.subscribe(params => {
      this.lightService.findLight(this.id).subscribe(data => {
        this.light = data;
      })
    })
  }
}
