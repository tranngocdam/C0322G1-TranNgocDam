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
  private LIST_URL = 'http://localhost:8080/api/public/api/book/list';
  private DEL_URL = 'http://localhost:8080/api/public/api/book/delete/';
  private CREATE_URL = 'http://localhost:8080/api/public/api/book/create';

  constructor(private http: HttpClient) {
  }

  findAllBook(): Observable<Book[]> {
    return this.http.get<Book[]>(this.LIST_URL);
  }

  deleteBook(id: number): Observable<Book> {
    return this.http.delete<Book>(this.DEL_URL + id);
  }

  saveBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.CREATE_URL, book);
  }
}
