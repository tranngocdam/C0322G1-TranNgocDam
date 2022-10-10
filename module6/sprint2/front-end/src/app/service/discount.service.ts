import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Discount} from '../model/discount';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {
  private LIST_URL = 'http://localhost:8080/api/public/api/discount/list';
  private ID_URL = 'http://localhost:8080/api/public/api/discount/';

  constructor(private http: HttpClient) {
  }

  findAllCompany(): Observable<Discount[]> {
    return this.http.get<Discount[]>(this.LIST_URL);
  }

  findById(id: number): Observable<Discount> {
    return this.http.get<Discount>(this.ID_URL + id);
  }
}
