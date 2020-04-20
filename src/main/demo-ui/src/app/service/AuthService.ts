import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, Route } from '@angular/router';
import { Observable } from 'rxjs';
import {PersonDTO} from "../dto/PersonDTO";

@Injectable()
export class AuthService {

  person: PersonDTO = null;
  userProfil : PersonDTO;
  connected: boolean = false;

  getPerson(): PersonDTO {
    return this.person;
  }

  setSession(profile: PersonDTO) {
    this.userProfil = profile;
    this.connected = true;
  }

  getUser() {
    return JSON.parse(localStorage.getItem('user'));
  }



}
