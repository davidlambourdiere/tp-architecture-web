import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SubscriptionDTO} from '../dto/SubscriptionDTO';
import {SubscriptionResidentDTO} from '../dto/SubscriptionResidentDTO';



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

  findSubscriptionByProfile(name: string): Observable<any> {
    return this.http.get<SubscriptionDTO>(`api/subscription/findSubscriptionByProfile/${name}`);
  }

  insertNewResidentInSubscription(createSubscription: SubscriptionDTO, login: string ): Observable<SubscriptionDTO> {
    createSubscription.description = login;
    return this.http.post<SubscriptionResidentDTO>(`api/subscription/insertSubscriptionForResident`, createSubscription);
  }
}
