import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {interval, Observable, Subscription} from "rxjs";
import {PositionDTO} from "../dto/PositionDTO";
import {startWith, switchMap} from "rxjs/operators";

1

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor(private http: HttpClient) {
  }

  findPositionByStrap(strapId: bigint): Observable<PositionDTO> {
    return interval(750).pipe(
      startWith(0),
      switchMap(() => this.http.get<PositionDTO>(`api/position/findByStrap/${strapId}`))
    );
  }

  simulatePosition(status: string): Subscription {
    return this.http.get(`api/position/insertPositionByStrap/` + status).subscribe();
  }

  positionHistory(strapId: bigint): Observable<Array<PositionDTO>> {
    return this.http.get<Array<PositionDTO>>(`api/position/positionHistory/${strapId}`);
  }

}
