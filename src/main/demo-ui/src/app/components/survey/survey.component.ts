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
import {SubscriptionService} from "../../service/SubscriptionService";
import {PersonProfileService} from "../../service/PersonProfileService";
import {SubscriptionDTO} from "../../dto/SubscriptionDTO";
import {PersonProfileDTO} from "../../dto/PersonProfileDTO";

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
  personprofile: PersonProfileDTO = new PersonProfileDTO();
  loginForm: FormGroup;
  trackName: any;
  isavalable : boolean = true;

  autonomie : number;


  //constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private fb: FormBuilder) { }
  constructor(private router: Router, private route: ActivatedRoute, private fb: FormBuilder, private personService: PersonProfileService){
  }
  ngOnInit() {
    this.loginForm = this.fb.group({

      Nom: ['laiouar', Validators.required],
      Prenom: ['nawfal', Validators.required],
      Age: [22, Validators.required],
      adress: ['13 rue des Marais', Validators.required],
      Code_Postal: ['94500', Validators.required],
      email: ['n.laiouar0@gmail.com', Validators.required],
      Telephone: ['0781519029', Validators.required],
      autonomie: [4, Validators.required],
      BAD_Autonomie: ['', Validators.required],
      fumeur_question: [false, Validators.required],
      fumeur: [0, Validators.required],
      buveur_question: [false, Validators.required],
      maladie: ['', Validators.required],
      urgence: [false, Validators.required],
      loisirsmodeVie: ['', Validators.required],
      revenu: [0, Validators.required]



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


  control(loginForm){
    console.log('Données.....', this.loginForm.value);
    //on transfere les valeurs des champs au DTO

    this.personprofile.adress = this.loginForm.get('adress').value;
    this.personprofile.adress_email = this.loginForm.get('email').value;
    this.personprofile.age = this.loginForm.get('Age').value;
    this.personprofile.chronic_disease = this.loginForm.get('maladie').value;
    this.personprofile.drinker = this.loginForm.get('buveur_question').value;
    this.personprofile.estimated_mobility = this.loginForm.get('autonomie').value;
    this.personprofile.hobbies = this.loginForm.get('loisirsmodeVie').value;
    this.personprofile.medical_emergencies = this.loginForm.get('urgence').value;
    this.personprofile.postal_code = this.loginForm.get('Code_Postal').value;
    this.personprofile.smoking = this.loginForm.get('fumeur_question').value;
    this.personprofile.tel_number = this.loginForm.get('Telephone').value;


    this.route.params.subscribe(params =>{
    this.personService.createPersonProfile(this.personprofile).subscribe(data => {
        this.personprofile = data;

    })
      })
  }


  toggle(andId){

      if(parseInt((<HTMLInputElement>document.getElementById(andId)).value) <= 5 )
      {
        Show("BAD_Autonomie");
        Show("bad_otonomie");
      }
      else
      {
        Hide("BAD_Autonomie");
        Hide("bad_otonomie");
      }
    }

  }


