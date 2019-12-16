import {Component, OnInit} from '@angular/core';
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent implements OnInit{

  person: PersonDTO;
  isConnectionGood: boolean;

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.person = new PersonDTO();
  }

  verifyConnection(){
    this.route.params.subscribe(params=> {
      this.personService.verifyConnection(this.person).subscribe(data=>{
        this.isConnectionGood = data;
        if(this.isConnectionGood === true){
          window.location.replace("/home");
        }
      })
    })

  }

  redirectionSurvey() {
      window.location.replace("/survey")
  }
}
