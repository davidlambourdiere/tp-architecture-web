import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ActivityAnalysisService} from "../../service/ActivityAnalysisService";
import {ActivityAnalysisDTO} from "../../dto/ActivityAnalysisDTO";
import {PersonService} from "../../service/PersonService";
import {PersonDTO} from "../../dto/PersonDTO";
import {ResidenceService} from "../../service/ResidenceService";
import {ResidenceDTO} from "../../dto/ResidenceDTO";

@Component({
  selector: 'activity-analysis',
  templateUrl: './activity.analysis.component.html',
  styleUrls: ['./activity.analysis.component.scss']
})
export class  ActivityAnalysisComponent {

  activityanalysisperson : ActivityAnalysisDTO = new ActivityAnalysisDTO();
  activityanalysisresidence : Object = new ActivityAnalysisDTO();
  activityanalysistotal : Object = new ActivityAnalysisDTO();
  personlist: PersonDTO[];
  residencelist: ResidenceDTO[];

  constructor(private router: Router, private route: ActivatedRoute, private activityanlysisservice: ActivityAnalysisService, private personservice : PersonService, private residenceservice: ResidenceService){

  }

  ngOnInit(){
    this.findAllPerson();
    this.findAllResidence();
    this.countIOT();
  }

  countIOTByPerson(personlogin: string) {
    this.route.params.subscribe(params =>{
      this.activityanlysisservice.countIOTByPerson(personlogin).subscribe(data=>{
        this.activityanalysisperson = data;
        });
    });
  }

  countIOTByResidence(idresidence : string) {
    this.route.params.subscribe(params =>{
      this.activityanlysisservice.countIOTByResidence(idresidence).subscribe(data=>{
        this.activityanalysisresidence = data;
      });
    });
  }

  countIOT() {
    this.route.params.subscribe(params =>{
      this.activityanlysisservice.countIOT().subscribe(data=>{
        this.activityanalysistotal = data;
      });
    });
  }

  private findAllPerson() {
    this.route.params.subscribe(params =>{
      this.personservice.findAllPerson().subscribe(data=>{
        this.personlist = data;
      });
    });
  }

  private findAllResidence() {
    this.route.params.subscribe(params =>{
      this.residenceservice.findAllResidence().subscribe(data=>{
        this.residencelist = data;
      });
    });
  }
}
