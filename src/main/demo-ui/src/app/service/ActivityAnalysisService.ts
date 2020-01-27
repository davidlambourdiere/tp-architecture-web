import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ActivityAnalysisDTO} from "../dto/ActivityAnalysisDTO";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ActivityAnalysisService{

  constructor(private http: HttpClient) {
  }

  countIOTByPerson(personlogin : string) : Observable<any>{
    return this.http.get(`api/analysis/countIOTByPerson/${personlogin}`);
  }

  countIOTByResidence(idresidence: string) {
    return this.http.get(`api/analysis/countIOTByResidence/${idresidence}`);
  }

  countIOT() {
    return this.http.get(`api/analysis/countIOT`);
  }
}
