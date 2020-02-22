import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PersonDTO} from '../dto/PersonDTO';
import {LightDTO} from "../dto/LightDTO";
import {ShutterDTO} from "../dto/ShutterDTO";

@Injectable({
  providedIn: 'root'
})
export class ShutterService {

  constructor(private http: HttpClient) {
  }



  findbyId(id: number) :Observable<ShutterDTO>{
    return this.http.get<ShutterDTO>(`api/shutter/${id}`);
  }

  updateShutter(id: number , shutter: ShutterDTO): Observable<ShutterDTO> {
    return this.http.put<ShutterDTO>(`api/shutter/updateShutter/${id}`, shutter);
  }




}
