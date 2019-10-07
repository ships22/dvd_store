import { AuthenticationService } from './authentication.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {

  constructor(private router: Router, private autheService: AuthenticationService) { }

  canActivate(rout: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.autheService.isLoggedIn())
      return true;

    this.router.navigate(['login']);
    return false;
  }
}
