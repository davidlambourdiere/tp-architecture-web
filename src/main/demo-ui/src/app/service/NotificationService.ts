import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {NotificationDTO} from "../dto/NotificationDTO";


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

  sendMessage(message: NotificationDTO): Observable<any>{
    return this.http.post(`api/notification/send`, message);
  }

  findMessagesReceived(username: string): Observable<any>{
    return this.http.get(`api/notification/received/${username}`);
  }

  findMessagesSent(username: string): Observable<any>{
    return this.http.get(`api/notification/sent/${username}`);
  }
}
