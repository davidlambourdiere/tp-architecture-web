import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IOTDTO} from "../dto/IOTDTO";

@Injectable({
  providedIn: 'root'
})
export class IOTService {
  constructor(private http: HttpClient) {
  }

  findAllIOT(): Observable<IOTDTO> {
    return this.http.get<IOTDTO>(`api/iots`);
  }

  findIOTByPerson(idperson: string): Observable<any> {
    return this.http.get(`api/iot/findByPerson/${idperson}`);
  }
}
