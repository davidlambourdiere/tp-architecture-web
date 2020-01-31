import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RoomDTO} from "../dto/RoomDTO";

@Injectable({
  providedIn: 'root'
})

export class RoomService{
  constructor(private http: HttpClient) {
  }

  findAllRoom(): Observable<RoomDTO> {
    return this.http.get<RoomDTO>(`api/rooms`);
  }
}
