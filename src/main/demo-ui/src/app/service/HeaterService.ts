import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IOTDTO} from "../dto/IOTDTO";
import {HeaterDTO} from "../dto/HeaterDTO";
import {LightDTO} from "../dto/LightDTO";

@Injectable({
  providedIn: 'root'
})
export class HeaterService {
  constructor(private http: HttpClient) {
  }



  findbyId(id: number) :Observable<HeaterDTO>{
    return this.http.get<HeaterDTO>(`api/heater/${id}`);
  }

  updateHeater(id: number , heater: HeaterDTO): Observable<HeaterDTO> {
    return this.http.put<HeaterDTO>(`api/heater/updateHeater/${id}`, heater);
  }

}
