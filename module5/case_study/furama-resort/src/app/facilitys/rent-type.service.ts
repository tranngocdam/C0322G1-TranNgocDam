import {Injectable} from '@angular/core';
import {RentType} from './RentType';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<RentType[]> {
    return this.http.get<RentType[]>(API_URL + '/rentType');
  }

  findById(id: number): Observable<RentType> {
    return this.http.get<RentType>(`${API_URL}/rentType/${id}`);
  }
}
