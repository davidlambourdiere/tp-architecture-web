import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PersonDTO} from "../dto/PersonDTO";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) {
  }

  findAllPerson(): Observable<PersonDTO[]> {
    return this.http.get<PersonDTO[]>(`api/person/findAll`);
  }


  find(id: number) :Observable<PersonDTO>{
    return this.http.get<PersonDTO>(`api/person/findById/${id}`);
  }
}
