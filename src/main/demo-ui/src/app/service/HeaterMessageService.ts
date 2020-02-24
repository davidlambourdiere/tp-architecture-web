import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeaterMessageService {
  constructor(private http: HttpClient) {
  }

  breakdownDetection(idHeater: string) {
    return this.http.get(`api/heaterMessages/breakdownDetection/${idHeater}`);
  }
}
