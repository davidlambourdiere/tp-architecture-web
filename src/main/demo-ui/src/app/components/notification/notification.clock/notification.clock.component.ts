import {Component, OnInit} from "@angular/core";
import {HeaterDTO} from "../../../dto/HeaterDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {HeaterService} from "../../../service/HeaterService";
import {ClockDTO} from "../../../dto/ClockDTO";
import {ClockService} from "../../../service/ClockService";

@Component({
  selector: 'notification/clock',
  templateUrl: './notification.clock.component.html',
  styleUrls: ['./notification.clock.component.scss']
})
export class NotificationClockComponent implements OnInit{

  id: string;
  clock: ClockDTO;

  constructor(private router: Router, private route: ActivatedRoute, private clockService: ClockService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findClock();
  }

  findClock(): void{
    this.route.params.subscribe(params => {
      this.clockService.findClock(this.id).subscribe(data => {
        this.clock = data;
      })
    })
  }
}

