import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {MaBenhAn} from '../model/ma-benh-an';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class MaBenhAnService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<MaBenhAn[]> {
    return this.http.get<MaBenhAn[]>(API_URL + '/mabenhan');
  }
  findById(id: number): Observable<MaBenhAn> {
    return this.http.get<MaBenhAn>(`${API_URL}/mabenhan/${id}`);
  }
}
