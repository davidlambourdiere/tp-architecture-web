import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StrapDTO} from "../dto/StrapDTO";

@Injectable({
  providedIn: 'root'
})
export class StrapService {
  constructor(private http: HttpClient) {
  }

  findAll(): Observable<StrapDTO[]> {
    return this.http.get<StrapDTO[]>(`api/strap/findAll`);
  }

  findById(id : bigint): Observable<StrapDTO> {
    return this.http.get<StrapDTO>(`api/strap/${id}`);
  }


  findStrap(id: string): Observable<any>{
      return this.http.get(`api/strap/find/${id}`);

  }
}
