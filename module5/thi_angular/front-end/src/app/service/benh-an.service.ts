import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenhAn} from '../model/benh-an';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {

  constructor(private http: HttpClient) {
  }

  getAll(page: number): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>(API_URL + '/?page=' + page);
  }

  findById(id: number): Observable<BenhAn> {
    return this.http.get<BenhAn>(`${API_URL}/find/${id}`);
  }

  saveBenhAn(benhan): Observable<BenhAn> {
    return this.http.post<BenhAn>(API_URL + '/create', benhan);
  }

  editBenhAn(id: number, benhan: BenhAn): Observable<BenhAn> {
    return this.http.patch<BenhAn>(`${API_URL}/edit/${id}`, benhan);
  }

  deleteCustomer(id: number): Observable<BenhAn> {
    return this.http.delete<BenhAn>(`${API_URL}/delete/${id}`);
  }

  searchBenhAn(liDo1: string): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>(`${API_URL}/benhan?liDo_like=` + liDo1);
  }
}
