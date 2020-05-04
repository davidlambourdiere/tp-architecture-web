import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PersonProfileDTO} from "../dto/PersonProfileDTO";

@Injectable({
  providedIn: 'root'
})
export class PersonProfileService {
  constructor(private http: HttpClient) {
  }

  findAllPerson(): Observable<PersonProfileDTO[]> {
    return this.http.get<PersonProfileDTO[]>('api/personProfile/findAll');
  }

  createPersonProfile(personProfile: PersonProfileDTO):Observable<PersonProfileDTO>{
   return this.http.post<PersonProfileDTO>('api/personProfile/createpersonProfile', personProfile);
  }


}
