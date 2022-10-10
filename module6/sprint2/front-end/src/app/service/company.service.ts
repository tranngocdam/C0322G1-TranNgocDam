import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Company} from '../model/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private LIST_URL = 'http://localhost:8080/api/public/api/company/list';
  private ID_URL = 'http://localhost:8080/api/public/api/company/';

  constructor(private http: HttpClient) {
  }

  findAllCompany(): Observable<Company[]> {
    return this.http.get<Company[]>(this.LIST_URL);
  }

  findById(id: number): Observable<Company> {
    return this.http.get<Company>(this.ID_URL + id);
  }
}
