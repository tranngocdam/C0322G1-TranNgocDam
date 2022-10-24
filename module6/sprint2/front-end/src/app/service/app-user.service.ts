import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {AppUser} from '../model/app-user';
import {Observable} from 'rxjs';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class AppUserService {

  constructor(private http: HttpClient) {
  }

  save(appUser: AppUser): Observable<AppUser> {
    return this.http.post<AppUser>(API_URL + '/app-user/create', appUser);
  }

  getAppUser(username: string): Observable<AppUser> {
    return this.http.get<AppUser>(API_URL + '/app-user/' + username);
  }
}
