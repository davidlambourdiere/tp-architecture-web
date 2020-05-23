import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PersonDTO} from "../dto/PersonDTO";

@Injectable({
  providedIn: 'root'
})

export class ResidenceService{
  constructor(private http: HttpClient) {
  }

  findAllResidence() : Observable<any>{
    return this.http.get(`api/residence/findAll`);
  }

  findAllPersonByResidenceId(residenceid: string) {
    return this.http.get<PersonDTO[]>(`api/person/findAllPersonByResidence/${residenceid}`);
  }

}
