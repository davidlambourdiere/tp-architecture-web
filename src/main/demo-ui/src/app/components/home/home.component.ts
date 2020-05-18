import {Component, OnInit} from "@angular/core";
import {PersonDTO} from "../../dto/PersonDTO";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
person: PersonDTO;

  constructor(private route: ActivatedRoute) {
    this.person = new PersonDTO();
  }

  ngOnInit(): void {
    this.person.login = this.route.snapshot.paramMap.get('login');
  }
}
