import {Component, OnInit} from '@angular/core';
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/AuthService";

@Component({
  selector: 'connection',
  templateUrl: './connection.component.html',
  styleUrls: ['./connection.component.scss']
})
export class ConnectionComponent implements OnInit {

  person: PersonDTO;
  isConnectionGood: boolean=null;

  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.person = new PersonDTO();
  }

  verifyConnection() {
    this.route.params.subscribe(params => {
      this.personService.verifyConnection(this.person).subscribe(data => {
        if (data != null) {

          this.person = data;
         console.log(JSON.stringify(this.person.profileType));
          this.authService.setSession(data);
          if (this.person.profileType == "confort")
            this.router.navigate(['/confort']);
          if (this.person.profileType == "essential") {
            this.router.navigate(['/essential']);
          }
          if (this.person.profileType == "serenity")
            this.router.navigate(['/serenity']);
          if (this.person.profileType == "totalconfort")
            this.router.navigate(['/total-confort']);
          if (this.person.profileType == null)
            this.router.navigate(['/home']);
        } else {
          this.isConnectionGood = false;
        }
      })
    })

  }

}
