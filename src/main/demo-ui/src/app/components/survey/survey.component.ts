import {FormBuilder, FormGroup, NgForm, ReactiveFormsModule} from "@angular/forms";
import {Component, NgModule, OnInit} from "@angular/core";
import { BrowserModule} from "@angular/platform-browser";
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
})
export class SurveyComponent implements OnInit {

  persons: PersonDTO[] = [];
  loginForm: FormGroup;

  //constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private fb: FormBuilder) { }
  constructor(private fb: FormBuilder){}
  ngOnInit() {
    this.loginForm = this.fb.group({

      Nom: ['laiouar'],
      Prenom: ['nawfal'],
      Age: ['22'],
      Adresse: ['13 rue des Marais'],
      Code_Postal: ['94500'],
      email: ['n.laiouar0@gmail.com'],
      Telephone: ['0781519027'],
      autonomie: [10],
      fumeur:[],


    }, {updateOn: 'blur'});

  }
  control(){
    console.log('Données.....', this.loginForm.value);
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
