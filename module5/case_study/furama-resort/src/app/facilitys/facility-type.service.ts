import {Injectable} from '@angular/core';
import {FacilityType} from './FacilityType';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Facility} from './Facility';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<FacilityType[]> {
    return this.http.get<FacilityType[]>(API_URL + '/facilityType');
  }

  findById(id: number): Observable<FacilityType> {
    return this.http.get<FacilityType>(`${API_URL}/facilityType/${id}`);
  }
}
