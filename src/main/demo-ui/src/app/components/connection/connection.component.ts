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
  isConnectionGood: boolean = null;

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
          console.log(JSON.stringify(this.person.profiletype));
          this.authService.setSession(data);
          if (this.person.profiletype === 'confort') {
            this.router.navigate(['/confort', this.person.login]);
          }
          if (this.person.profiletype === 'essential') {
            this.router.navigate(['/essential', this.person.login]);
          }
          if (this.person.profiletype === 'serenity') {
            this.router.navigate(['/serenity', this.person.login]);
          }
          if (this.person.profiletype === 'total-confort') {
            this.router.navigate(['/total-confort', this.person.login]);
          }
          if (this.person.profiletype == null) {
            this.router.navigate(['/home', this.person.login]);
          }
        } else {
          this.isConnectionGood = false;
        }
      });
    });

  }

}
