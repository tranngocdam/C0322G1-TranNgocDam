import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {MaBenhNhan} from '../model/ma-benh-nhan';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class MaBenhNhanService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<MaBenhNhan[]> {
    return this.http.get<MaBenhNhan[]>(API_URL + '/mabenhnhan');
  }
  findById(id: number): Observable<MaBenhNhan> {
    return this.http.get<MaBenhNhan>(`${API_URL}/mabenhnhan/${id}`);
  }
}
