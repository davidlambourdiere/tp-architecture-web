import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PositionDTO} from "../dto/PositionDTO";

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor(private http: HttpClient) { }

  findPositionByStrap(strapId: number): Observable<PositionDTO>{
    return this.http.get<PositionDTO>  (`api/position/findByStrap/${strapId}`);
  }
}
