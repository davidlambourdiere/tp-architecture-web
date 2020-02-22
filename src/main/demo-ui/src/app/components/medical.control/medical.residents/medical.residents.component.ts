import { Component, OnInit } from '@angular/core';
import {PersonService} from "../../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {PersonDTO} from "../../../dto/PersonDTO";
import {Observable} from "rxjs";

@Component({
  selector: 'app-medicalresidents',
  templateUrl: './medical.residents.component.html',
  styleUrls: ['./medical.residents.component.scss']
})
export class MedicalResidentsComponent implements OnInit {
  personlist: PersonDTO[];
  constructor(private personservice: PersonService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    // @ts-ignore
    this.personlist = this.findAllPeron();
  }

  private findAllPeron() {
    this.route.params.subscribe(params =>{
      this.personservice.findAllPerson().subscribe(data=>{
        this.personlist = data;
      });
    });
  }
}
