import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {HealthHistoricDTO} from "../dto/HealthHistoricDTO";

@Injectable({
  providedIn: 'root'
})
export class HealthHistoricService {

  constructor(private http: HttpClient) {
  }


 findTopByStrap(id:  bigint) :Observable<HealthHistoricDTO>{
    return this.http.get<HealthHistoricDTO>(`api/health/historic/findHistoric/${id}`);
  }


  findAllByStrap(id:  bigint) : Observable<HealthHistoricDTO[]>{
    return this.http.get<HealthHistoricDTO[]>(`api/health/historic/findHistoricByStrap/${id}`);
  }
}
