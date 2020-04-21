import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PersonDTO} from '../dto/PersonDTO';
import {ALertHealthDTO} from "../dto/AlertHealthDTO";
import {StrapDTO} from "../dto/StrapDTO";

@Injectable({
  providedIn: 'root'
})
export class AlertHealthService {

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<ALertHealthDTO[]> {
    return this.http.get<ALertHealthDTO[]>(`api/alert/health/findAll`);
  }


 /* find(id: number) :Observable<PersonDTO>{
    return this.http.get<PersonDTO>(`api/person/findById/${id}`);
  }*/


  findNewAlerts() {
    return this.http.get<ALertHealthDTO[]>(`api/alert/health/findNewAlerts`);
  }

  findAlertNumber() {
    return this.http.get<Number>(`api/alert/health/findAlertNumber`);
  }

  findAlertNumberByPerson(person: PersonDTO):Observable<Number> {
    return this.http.post<Number>(`api/alert/health/findAlertNumberByPerson`, person);
  }

  findById(id : bigint): Observable<ALertHealthDTO> {
    return this.http.get<ALertHealthDTO>(`api/alert/health/findById/${id}`);
  }
}
