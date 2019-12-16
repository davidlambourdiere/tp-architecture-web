import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ActivityAnalysisService} from "../../service/ActivityAnalysisService";
import {ActivityAnalysisDTO} from "../../dto/ActivityAnalysisDTO";
import {PersonService} from "../../service/PersonService";
import {PersonDTO} from "../../dto/PersonDTO";

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

  constructor(private router: Router, private route: ActivatedRoute, private activityanlysisservice: ActivityAnalysisService, private personservice : PersonService){

  }

  ngOnInit(){
    this.findAllPeron();
    this.countIOTByResidence();
    this.countIOT();
  }

  countIOTByPerson(personlogin: string) {
    this.route.params.subscribe(params =>{
      this.activityanlysisservice.countIOTByPerson(personlogin).subscribe(data=>{
        this.activityanalysisperson = data;
        });
    });
  }

  countIOTByResidence() {
    this.route.params.subscribe(params =>{
      this.activityanlysisservice.countIOTByResidence('1').subscribe(data=>{
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

  private findAllPeron() {
    this.route.params.subscribe(params =>{
      this.personservice.findAllPerson().subscribe(data=>{
        this.personlist = data;
      });
    });
  }
}
