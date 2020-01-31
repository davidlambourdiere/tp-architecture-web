import {
  FormBuilder,
  FormGroup,
  NgForm,
  ReactiveFormsModule,
  FormsModule,
  Validators,
  FormControl
} from "@angular/forms";
import {Component, Input, NgModule, OnInit} from "@angular/core";
import { BrowserModule} from "@angular/platform-browser";
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {parseFieldArrayValue} from "@angular/compiler-cli/src/ngtsc/annotations/src/directive";
import {importType} from "@angular/compiler/src/output/output_ast";

function Show(addr) { document.getElementById(addr).style.visibility = "visible";

}

function Hide(addr) { document.getElementById(addr).style.visibility = "hidden";

}

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
})


export class SurveyComponent implements OnInit {

  persons: PersonDTO[] = [];
  loginForm: FormGroup;
  trackName: any;
  isavalable : boolean = true;
  autonomie : boolean = true;

  //constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private fb: FormBuilder) { }
  constructor(private router: Router, private route: ActivatedRoute, private fb: FormBuilder){

  }
  ngOnInit() {
    this.loginForm = this.fb.group({

      Nom: ['laiouar', Validators.required],
      Prenom: ['nawfal', Validators.required],
      Age: ['22', Validators.required],
      Adresse: ['13 rue des Marais'],
      Code_Postal: ['94500'],
      email: ['n.laiouar0@gmail.com', Validators.required],
      Telephone: ['0781519029', Validators.required],
      autonomie: [4, Validators.required],
      fumeur:[],


    }, {updateOn: 'blur'});
    window.onload = function () { Hide("BAD_Autonomie");

    }
    Hide("bad_otonomie");
    Hide("BAD_Autonomie");

  }
  /*Nom= new FormControl( 'laiouar', [Validators.required]);
  Prenom = new FormControl('nawfal', [Validators.required]);
  Age = new FormControl ('22', [Validators.required]);
  Adresse = new FormControl ('13 rue des Marais');
  Code_Postal = new FormControl ('94500');
  email = new FormControl ('n.laiouar0@gmail.com', [Validators.required]);
  Telephone = new FormControl('0781519029', [Validators.required]);
  autonomie = new FormControl(4,[ Validators.required]);
  fumeur = new FormControl();*/


  control(form: NgForm){
    console.log('Données.....', form.value);
  }

  toggle(anId){
    if (document.getElementById(anId).style.visibility == "hidden" ) {
      Show(anId);
    } else {Hide(anId);}

  }

  getCurrentModel(){
    return JSON.stringify(this.loginForm);
  }
  autonomieValue(){
    this.autonomie = false;

  }

 //showPerson() {
   // this.route.params.subscribe(params=> {
     // this.personService.findAllPerson().subscribe(data=>{
       // this.persons = data;
     // })
    //})
 // }

  //hidePerson() {
    //this.persons = [];
 // }

}
