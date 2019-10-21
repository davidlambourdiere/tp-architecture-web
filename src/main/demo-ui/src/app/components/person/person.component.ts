import { Component, OnInit } from '@angular/core';
import {PersonService} from '../../service/PersonService';
import {ActivatedRoute, Router} from '@angular/router';
import {PersonDTO} from '../../dto/PersonDTO';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.scss']
})
export class PersonComponent implements OnInit {

  persons: PersonDTO[] = [];
  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params=> {
      this.personService.findAllPerson().subscribe(data=>{
        this.persons = data;
      })
    })
  }

}
