import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {IOTService} from "../../../service/IOTService";

@Component({
  selector: 'detailiot',
  templateUrl: './detail.iot.component.html',
  styleUrls: ['./detail.iot.component.scss']
})
export class DetailIotComponent implements OnInit {

  id: String;

  constructor(private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
  }
}
