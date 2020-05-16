import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClockDTO} from "../dto/ClockDTO";
import {ShutterDTO} from "../dto/ShutterDTO";

@Injectable({
  providedIn: 'root'
})
export class ClockService {
  constructor(private http: HttpClient) {
  }

  findIOTByRoom(idroom: string): Observable<any>{
    return this.http.get(`api/clock/findByRoom/${idroom}`);
  }

  updateClock(id: bigint , clock: ClockDTO): Observable<ClockDTO> {
    return this.http.put<ClockDTO>(`api/clock/updateClock/${id}`, clock);
  }
}
