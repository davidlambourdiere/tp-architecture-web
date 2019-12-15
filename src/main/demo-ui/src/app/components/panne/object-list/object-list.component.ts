import {Component, Input, OnInit} from '@angular/core';
import {IOTDTO} from "../../../dto/IOTDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {IOTService} from "../../../service/IOTService";


@Component({
  selector: 'app-object-list',
  templateUrl: './object-list.component.html',
  styleUrls: ['./object-list.component.scss']
})
export class ObjectListComponent implements OnInit {
  @Input() IOTType : string;
  @Input() IOTStatus : string;


  constructor(private router: Router, private route: ActivatedRoute, private iotservice: IOTService) {

  }

  ngOnInit() {
  }



}
