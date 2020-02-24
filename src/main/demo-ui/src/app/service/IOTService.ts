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

  findAllIOTWithMalfunctionning(): Observable<IOTDTO> {
    return this.http.get<IOTDTO>(`api/iots/malfunctionning`);
  }

  findIOTByType(type: string): Observable<IOTDTO> {
    return this.http.post<IOTDTO>(`api/iots/findByType`, type);
  }

  findIOTByPerson(idperson: string): Observable<any> {
    return this.http.get(`api/iots/findByPerson/${idperson}`);
  }

  findIOTByIdAndType(idperson: string, type: string): Observable<any>{
    return null;
  }

  findClockDetailWithHistoric(id: string): Observable<any>{
    return this.http.get(`api/clock/findHistoric/${id}`);
  }

  findLightDetailWithHistoric(id: string): Observable<any>{
    return this.http.get(`api/light/findHistoric/${id}`);
  }

  findShutterDetailWithHistoric(id: string): Observable<any>{
    return this.http.get(`api/shutter/findHistoric/${id}`);
  }

  findStrapDetailWithHistoric(id: string): Observable<any>{
    return this.http.get(`api/strap/findHistoric/${id}`);
  }

  findHeaterDetailWithHistoric(id: string): Observable<any>{
    return this.http.get(`api/heater/findHistoric/${id}`);
  }



}
