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

  activityanalysis : Object = new ActivityAnalysisDTO();
  personlist: PersonDTO[];
  residencelist: ResidenceDTO[];

  constructor(private router: Router, private route: ActivatedRoute, private activityanlysisservice: ActivityAnalysisService, private personservice : PersonService, private residenceservice: ResidenceService){

  }

  ngOnInit(){
    this.findAllResidence();
    this.findAllPerson();
  }

  countIOT() {
    this.route.params.subscribe(params =>{
      this.activityanlysisservice.countIOT().subscribe(data=>{
        this.activityanalysis = data;
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

  getAllPersonsByResidenceId(residenceid: string) {
    if (residenceid == '0'){
      this.findAllPerson();
    }else {
      this.route.params.subscribe(params => {
        this.residenceservice.findAllPersonByResidenceId(residenceid).subscribe(data => {
          this.personlist = data;
        });
      });
    }
  }
}
