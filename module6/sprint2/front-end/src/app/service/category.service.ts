import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private LIST_URL = 'http://localhost:8080/api/public/api/category/list';
  private ID_URL = 'http://localhost:8080/api/public/api/category/';
  constructor(private http: HttpClient) {
  }

  findAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(this.LIST_URL);
  }
  findById(id: number): Observable<Category> {
    return this.http.get<Category>(this.ID_URL + id);
  }
}
