import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {HeaterService} from "../../../service/HeaterService";

@Component({
  selector: 'notification/heater',
  templateUrl: './notification.heater.component.html',
  styleUrls: ['./notification.heater.component.scss']
})
export class NotificationHeaterComponent implements OnInit{

  id: string;
  heater: HeaterDTO;

  constructor(private router: Router, private route: ActivatedRoute, private heaterService: HeaterService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findHeater();
  }

  findHeater(): void{
    this.route.params.subscribe(params => {
      this.heaterService.findHeater(this.id).subscribe(data => {
        this.heater = data;
      })
    })
  }
}
