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

  findActivityAnalysis(activityanalysis: ActivityAnalysisDTO) {
    return this.http.post<ActivityAnalysisDTO>(`api/analysis/`,activityanalysis);
  }
}
