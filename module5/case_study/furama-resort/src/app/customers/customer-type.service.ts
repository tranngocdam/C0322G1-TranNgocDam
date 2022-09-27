import {Injectable} from '@angular/core';
import {CustomerType} from './customerType';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  // customerType: CustomerType[] = [{
  //   id: 1,
  //   name: 'Diamond'
  // }, {
  //   id: 2,
  //   name: 'Platinium'
  // }, {
  //   id: 3,
  //   name: 'Gold'
  // }, {
  //   id: 4,
  //   name: 'Sliver'
  // }, {
  //   id: 5,
  //   name: 'Member'
  // }];


  constructor(private http: HttpClient) {
  }

  getAll(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(API_URL + '/customerType');
  }

  findById(id: number): Observable<CustomerType>  {
    return this.http.get<CustomerType>(`${API_URL}/customerType/${id}`);
  }
}
