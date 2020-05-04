import {Component} from "@angular/core";
import { BrowserModule} from "@angular/platform-browser";
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {parseFieldArrayValue} from "@angular/compiler-cli/src/ngtsc/annotations/src/directive";
import {importType} from "@angular/compiler/src/output/output_ast";
import {SubscriptionService} from "../../service/SubscriptionService";
import {PersonProfileService} from "../../service/PersonProfileService";
import {SubscriptionDTO} from "../../dto/SubscriptionDTO";
import {PersonProfileDTO} from "../../dto/PersonProfileDTO";
import set = Reflect.set;
import {FormBuilder} from "@angular/forms";
import {Observable} from "rxjs";

@Component({
  selector: 'resident',
  templateUrl: './resident.component.html',
})
//styleUrls: ['./resident.component.scss']

export class ResidentComponent {

  tab: any[] = [];
  public persons: PersonProfileDTO[] = [];

  constructor(private router: Router, private route: ActivatedRoute, private fb: FormBuilder, private personService: PersonProfileService){
  }
  ngOnInit() {

    this.route.params.subscribe(params=> {
     this.personService.findAllPerson().subscribe(data=>{
       this.persons = data;
       console.log(data);
      })
    })


  }

}
