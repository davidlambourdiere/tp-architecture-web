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



  findbyId(id: bigint) :Observable<HeaterDTO>{
    return this.http.get<HeaterDTO>(`api/heater/${id}`);
  }

  updateHeater(id: bigint , heater: HeaterDTO): Observable<HeaterDTO> {
    return this.http.put<HeaterDTO>(`api/heater/updateHeater/${id}`, heater);
  }

  findbyIpAdress(ipadress: string) :Observable<HeaterDTO>{
      return this.http.get<HeaterDTO>(`api/heater/${ipadress}`);
  }

  findIOTByRoom(idroom: string): Observable<any> {
    return this.http.get(`api/heater/findByRoom/${idroom}`);
  }

  countHeaters() {
    return this.http.get(`api/heater/countHeaters`);
  }

}
