import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {PersonService} from "../service/PersonService";
import {AuthService} from "../service/AuthService";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {


  constructor(private _authService: AuthService, private _router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    console.log(this._authService.getPerson())
    if (this._authService.connected) {
      return true;
    }

    // navigate to login page
    this._router.navigate(['']);
    // you can save redirect url so after authing we can move them back to the page they requested
    return false;
  }
}
