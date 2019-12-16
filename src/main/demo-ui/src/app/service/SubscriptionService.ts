import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SubscriptionDTO} from '../dto/SubscriptionDTO';



@Injectable({
  providedIn: 'root'
})
export class SubscriptionService{
  constructor(private http: HttpClient) {
  }

  findAllSubscription(): Observable<SubscriptionDTO> {
    return this.http.get<SubscriptionDTO>(`api/subscription`);
  }

  findSubscriptionbyId(idSubscription: string): Observable<SubscriptionDTO> {
    return this.http.post<SubscriptionDTO>(`api/subscription/findById`, idSubscription);
  }


}
