import {Injectable} from '@angular/core';
import {Customer} from './customer';
import {CustomerType} from './customerType';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  // customers: Customer[] = [{
  //   id: 1,
  //   name: 'Bảo Bình',
  //   dayOfBirth: '2010-10-21',
  //   gender: true,
  //   customerTypeId: {id: 2, name: 'Platinium'},
  //   idCard: '3434343444',
  //   email: 'baobinh23@gmail.com',
  //   phoneNumber: '090212212',
  //   address: '34 Nam Cao'
  // }, {
  //   id: 2,
  //   name: 'Lam Linh',
  //   dayOfBirth: '1990-03-22',
  //   gender: false,
  //   customerTypeId: {id: 4, name: 'Silver'},
  //   idCard: '2321579900',
  //   email: 'linh90@gmail.com',
  //   phoneNumber: '0912323122',
  //   address: '120 Âu Cơ'
  // }, {
  //   id: 3,
  //   name: 'Chấn Hiệp',
  //   dayOfBirth: '1998-01-12',
  //   gender: true,
  //   customerTypeId: {id: 5, name: 'Member'},
  //   idCard: '2324449900',
  //   email: 'hiep98@gmail.com',
  //   phoneNumber: '0912000122',
  //   address: '11 Phạm Như Xương'
  // }, {
  //   id: 4,
  //   name: 'Minh Nhí',
  //   dayOfBirth: '1999-06-08',
  //   gender: false,
  //   customerTypeId: {id: 1, name: 'Diamond'},
  //   idCard: '676575500',
  //   email: 'nhi999@gmail.com',
  //   phoneNumber: '0912000000',
  //   address: '08 Phạm Hùng'
  // }];
  //

  //
  // getAll() {
  //   return this.customers;
  // }
  // saveCustomer(customer) {
  //   this.customers.push(customer);
  // }
  // findById(id: number) {
  //   return this.customers.find(customer => customer.id === id);
  // }
  // deleteCustomer(id: number) {
  //   for (let i = 0; i < this.customers.length; i++) {
  //     if (this.customers[i].id === id) {
  //       this.customers.splice(i, 1);
  //     }
  //   }
  // }
  // updateCustomer(customer) {
  //   this.customers.find(c => c.id === customer.id).name = customer.name;
  //   this.customers.find(c => c.id === customer.id).customerTypeId  = customer.customerTypeId ;
  //   this.customers.find(c => c.id === customer.id).dayOfBirth = customer.dayOfBirth;
  //   this.customers.find(c => c.id === customer.id).gender = customer.gender;
  //   this.customers.find(c => c.id === customer.id).idCard = customer.idCard;
  //   this.customers.find(c => c.id === customer.id).phoneNumber = customer.phoneNumber;
  //   this.customers.find(c => c.id === customer.id).email = customer.email;
  //   this.customers.find(c => c.id === customer.id).address = customer.address;
  // }
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/customer');
  }

  saveCustomer(customer): Observable<Customer> {
    return this.http.post<Customer>(API_URL + '/customer', customer);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${API_URL}/customer/${id}`);
  }

  editCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${API_URL}/customer/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${API_URL}/customer/${id}`);
  }
  searchCustomer(name1: string, name2: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${API_URL}/customer?name_like=` + name1 + '&customerType.name_like=' + name2);
  }
}
