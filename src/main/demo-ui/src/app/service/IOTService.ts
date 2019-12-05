import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class IOTService {
  constructor(private http: HttpClient) {
  }

  findAllIOT(): Observable<any> {
    return this.http.get(`api/iot/findAllIOT`);
  }

  findIOTByPerson(idperson: string): Observable<any> {
    return this.http.get(`api/iot/findByPerson/${idperson}`);
  }
}
