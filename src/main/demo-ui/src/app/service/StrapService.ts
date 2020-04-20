import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ShutterDTO} from "../dto/ShutterDTO";

@Injectable({
  providedIn: 'root'
})
export class StrapService {

  constructor(private http: HttpClient) {
  }

  findStrap(id: string) : Observable<any> {
    return this.http.get(`api/strap/find/${id}`);
  }
}
