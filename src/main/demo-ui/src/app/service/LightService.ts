import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LightDTO} from "../dto/LightDTO";

@Injectable({
  providedIn: 'root'
})
export class LightService {

  constructor(private http: HttpClient) {
  }
  findIOTByRoom(idroom: string): Observable<any> {
    return this.http.get(`api/light/findByRoom/${idroom}`);
  }



  findbyId(id: bigint) :Observable<LightDTO>{
    return this.http.get<LightDTO>(`api/light/${id}`);
  }

<<<<<<< HEAD
  updateLight(id: bigint , light: LightDTO): Observable<LightDTO> {
    return this.http.put<LightDTO>(`api/light/updateLight/${id}`, light);
  }
=======
  // updateLight(id: bigint , light: LightDTO): Observable<LightDTO> {
   // return this.http.put<LightDTO>(`api/light/updateLight/${id}`, light);
  // }
>>>>>>> parent of 33782fd... changements mineurs


  updateLight(id: number , light: LightDTO): Observable<LightDTO> {
    return this.http.put<LightDTO>(`api/light/updateLight/${id}`, light);
  }
}
