import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SensorService {

  constructor(private http: HttpClient) {
  }

  findAllSensors(): Observable<any> {
    return this.http.get(`api/sensor/findAll`);
  }
}
