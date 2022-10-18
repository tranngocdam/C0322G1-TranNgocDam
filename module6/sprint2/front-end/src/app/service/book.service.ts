import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from '../model/book';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private DEL_URL = 'http://localhost:8080/api/public/api/book/delete/';
  private CREATE_URL = 'http://localhost:8080/api/public/api/book/create';
  private UPDATE_URL = 'http://localhost:8080/api/public/api/book/update/';
  private ID_URL = 'http://localhost:8080/api/public/api/book/';

  constructor(private http: HttpClient) {
  }

  findAll(page: number, keyword: string, size: number): Observable<Book[]> {
    return this.http.get<Book[]>(API_URL + '/api/book/list?page=' + page + '&keyword=' + keyword + '&size=' + size);
  }

  deleteBook(id: number): Observable<Book> {
    return this.http.delete<Book>(this.DEL_URL + id);
  }

  saveBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.CREATE_URL, book);
  }

  updateBook(id: number, book: Book): Observable<Book> {
    return this.http.put<Book>(this.UPDATE_URL + id, book);
  }

  findById(id: number): Observable<Book> {
    return this.http.get<Book>(this.ID_URL + id);
  }

  getDetail() {
    let detailJson = sessionStorage.getItem('detail');
    if (detailJson) {
      return JSON.parse(detailJson);
    } else {
      return [];
    }
  }
}
