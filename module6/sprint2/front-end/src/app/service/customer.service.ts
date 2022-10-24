import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {
  }

  getCustomer(id: number): Observable<Customer> {
    return this.http.get<Customer>(API_URL + '/customer/' + id);
  }

  edit(customer: Customer): Observable<Customer> {
    return this.http
      .put<Customer>(API_URL + `/customer/update`, customer);
  }

  save(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL + '/customer/create', customer);
  }
}
