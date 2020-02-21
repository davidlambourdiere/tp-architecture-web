import { Component, OnInit } from '@angular/core';
import {PersonService} from "../../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";

@Component({
  selector: 'app-medicalhome',
  templateUrl: './medical.home.component.html',
  styleUrls: ['./medical.home.component.scss']
})
export class MedicalHomeComponent implements OnInit {

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private authService: AuthService) {
  }

  ngOnInit() {
  }

}
