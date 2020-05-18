import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PersonDTO} from "../dto/PersonDTO";

@Injectable({
  providedIn: 'root'
})
export class BillingService {
  constructor(private http: HttpClient) {
  }

  billingReport(login: string): Observable<any> {
  return this.http.get(`api/billing/${login}`,  {responseType: 'blob'});
  }
}
