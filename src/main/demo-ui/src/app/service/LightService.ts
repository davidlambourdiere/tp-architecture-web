import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PersonDTO} from '../dto/PersonDTO';
import {LightDTO} from "../dto/LightDTO";

@Injectable({
  providedIn: 'root'
})
export class LightService {

  constructor(private http: HttpClient) {
  }

  findLight(id: string) : Observable<any> {
    return this.http.get(`api/light/find/${id}`);
  }

  findbyId(id: number) :Observable<LightDTO>{
    return this.http.get<LightDTO>(`api/light/${id}`);
  }

  updateLight(id: number , light: LightDTO): Observable<LightDTO> {
    return this.http.put<LightDTO>(`api/light/updateLight/${id}`, light);
  }


}
