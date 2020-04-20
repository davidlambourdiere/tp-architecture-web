import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) {
  }


  findUser(username: string): Observable<any>{
    return this.http.get(`api/notification/findUser/${username}`);
  }

  initializedNotification(username: string): Observable<any>{
    return this.http.get(`api/notification/initialized/${username}`);
  }

}
