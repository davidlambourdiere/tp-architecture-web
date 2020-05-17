import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MockIOTAndServiceService {
  constructor(private http: HttpClient) {
  }

  startMock() {
    return this.http.get(`api/billing/mock/start`);
   }
}
