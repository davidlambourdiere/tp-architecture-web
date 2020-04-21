import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LightService {
  constructor(private http: HttpClient) {
  }

  findIOTByRoom(idroom: string): Observable<any> {
    return this.http.get(`api/light/findByRoom/${idroom}`);
  }
}
