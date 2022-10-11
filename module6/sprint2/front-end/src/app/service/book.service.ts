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
  private UPDATE_URL = 'http://localhost:8080/api/public/api/book/update/';
  private ID_URL = 'http://localhost:8080/api/public/api/book/';

  constructor(private http: HttpClient) {
  }

  findAllBook(): Observable<Book[]> {
    return this.http.get<Book[]>(this.LIST_URL);
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

  getCards() {
    let cardJson = sessionStorage.getItem('card');
    if (cardJson) {
      return JSON.parse(cardJson);
    } else {
      return [];
    }
  }

  saveCarts(card: any) {
    let cardJson = JSON.stringify(card);
    sessionStorage.setItem('card', cardJson);
  }

  getTotalCartQuantity(): number {
    let cardList = this.getCards();
    let totalQuantity = 0;
    cardList.forEach((item: any) => {
      totalQuantity += item.quantity;
    });
    return totalQuantity;
  }

  getTotalCartPrice(): number {
    let cardList = this.getCards();
    let totalPrice = 0;
    cardList.forEach((item: any) => {
      totalPrice += item.quantity * item.price;
    });
    return totalPrice;
  }
  findById(id: number): Observable<Book> {
    return this.http.get<Book>(this.ID_URL + id);
  }
}
