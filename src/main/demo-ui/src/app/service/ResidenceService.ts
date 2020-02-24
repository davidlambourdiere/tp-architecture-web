import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class ResidenceService{
  constructor(private http: HttpClient) {
  }

  findAllResidence() : Observable<any>{
    return this.http.get(`api/residence/findAll`);
  }
}
