import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClockDTO} from "../dto/ClockDTO";

@Injectable({
  providedIn: 'root'
})
export class ClockService {
  constructor(private http: HttpClient) {
  }

  findIOTByRoom(idroom: string): Observable<any>{
    return this.http.get(`api/clock/findByRoom/${idroom}`);
  }
}
