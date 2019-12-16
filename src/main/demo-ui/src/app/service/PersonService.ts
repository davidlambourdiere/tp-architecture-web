import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PersonDTO} from '../dto/PersonDTO';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) {
  }

  findAllPerson(): Observable<any> {
    return this.http.get(`api/person/findAll`);
  }

  verifyConnection(person: PersonDTO): Observable<PersonDTO> {
    return this.http.post<PersonDTO>(`api/person/verifyConnection`, person);
  }


}
