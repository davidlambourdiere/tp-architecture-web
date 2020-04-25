import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {interval, Observable} from "rxjs";
import {PositionDTO} from "../dto/PositionDTO";
import {startWith, switchMap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor(private http: HttpClient) { }

  findPositionByStrap(strapId: bigint): Observable<PositionDTO>{
    return interval(5000).pipe(
      startWith(0),
      switchMap(() => this.http.get<PositionDTO>  (`api/position/findByStrap/${strapId}`))
    );
    //return ;
  }
}
