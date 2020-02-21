import {Component} from "@angular/core";
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/AuthService";
import {MedicalHomeComponent} from "./medical.home/medical.home.component";


@Component({
  selector: 'medicalControl',
  templateUrl: './medical.control.component.html',
  styleUrls: ['./medical.control.component.scss']
})
export class MedicalControlComponent {

  constructor() { }

  ngOnInit() {
  }


}
