import {Component, OnInit} from "@angular/core";
import {LightDTO} from "../../../dto/LightDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {LightService} from "../../../service/LightService";
import {ShutterDetailDTO} from "../../../dto/ShutterDetailDTO";
import {ShutterDTO} from "../../../dto/ShutterDTO";
import {ShutterService} from "../../../service/ShutterService";

@Component({
  selector: 'notification/shutter',
  templateUrl: './notification.shutter.component.html',
  styleUrls: ['./notification.shutter.component.scss']
})
export class NotificationShutterComponent implements OnInit{

  id: string;
  shutter: ShutterDTO;

  constructor(private router: Router, private route: ActivatedRoute, private shutterService: ShutterService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findShutter();
  }

  findShutter(): void{
    this.route.params.subscribe(params => {
      this.shutterService.findShutter(this.id).subscribe(data => {
        this.shutter = data;
      })
    })
  }
}
