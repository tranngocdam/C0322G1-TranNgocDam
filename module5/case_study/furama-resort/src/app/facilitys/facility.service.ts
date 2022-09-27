import {Injectable} from '@angular/core';
import {Facility} from './Facility';
import {RentType} from './RentType';
import {FacilityType} from './FacilityType';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  // facilitys: Facility[] = [{
  //   id : 1,
  //   name : 'OCEAN STUDIO SUITE',
  //   area : '65.5m2',
  //   cost : '563$',
  //   maxPeople : 5,
  //   rentTypeId : {id : 2, name : 'month'},
  //   facilityTypeId : {id : 2, name: 'house'},
  //   standardRoom : 'vip',
  //   descriptionOtherConvenience : 'có hồ bơi',
  //   poolArea : 32,
  //   numberOfFloods : 3 ,
  //   facilityFree : 'coca',
  //   img : 'https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Garden-Deluxe-twin-bed-F-370x239.jpg'
  // }, {
  //   id : 2,
  //   name : 'OCEAN SUITE',
  //   area :  '85.5m2',
  //   cost : '869$',
  //   maxPeople : 13,
  //   rentTypeId : {id : 3, name : 'day'},
  //   facilityTypeId : {id : 3, name: 'villa'},
  //   standardRoom : 'normal',
  //   descriptionOtherConvenience : 'có lò nướng',
  //   poolArea : 41,
  //   numberOfFloods : 4 ,
  //   facilityFree : 'tiger beer',
  //   img : 'https://thegioidulich.com//upload/khachsan/hinhchitiet/furama-resort-da-nang-4.png'
  // }, {
  //     id : 3,
  //     name : 'LAGOON SUPERIOR',
  //     area : '122.5m2',
  //     cost : '869$',
  //     maxPeople : 7,
  //     rentTypeId : {id : 2, name : 'month'},
  //     facilityTypeId : {id : 1, name: 'room'},
  //     standardRoom : 'normal',
  //     descriptionOtherConvenience : 'có lò nướng',
  //     poolArea : 41,
  //     numberOfFloods : 4 ,
  //     facilityFree : 'tiger beer',
  //     img : 'https://thegioidulich.com//upload/khachsan/hinhchitiet/furama-resort-da-nang-2.png'
  // }, {
  //   id : 4,
  //   name : 'LAGOON SUPERIOR',
  //   area : '82m2',
  //   cost : '109$',
  //   maxPeople : 5,
  //   rentTypeId : {id : 3, name : 'day'},
  //   facilityTypeId : {id : 1, name: 'room'},
  //   standardRoom : 'normal',
  //   descriptionOtherConvenience : 'có lò nướng',
  //   poolArea : 41,
  //   numberOfFloods : 4 ,
  //   facilityFree : 'tiger beer',
  //   img : 'https://s3-ap-southeast-1.amazonaws.com/viettrip/Rooms/6b596880-5e9e-4142-b029-a8e00223123b/162808_29122017_furama-resort-da-nang-viettrip36.jpg'
  // }, {
  //   id : 5,
  //   name : 'VILLA SUPERIOR',
  //   area : '122.5m2',
  //   cost : '1200$',
  //   maxPeople : 7,
  //   rentTypeId : {id : 2, name : 'month'},
  //   facilityTypeId : {id : 1, name: 'room'},
  //   standardRoom : 'normal',
  //   descriptionOtherConvenience : 'có lò nướng',
  //   poolArea : 41,
  //   numberOfFloods : 4 ,
  //   facilityFree : 'tiger beer',
  //   img : 'http://thuevilla.com/wp-content/uploads/2016/03/43345033.jpg'
  // }, {
  //   id : 6,
  //   name : 'GARDEN DELUXE',
  //   area : '62.5m2',
  //   cost : '869$',
  //   maxPeople : 7,
  //   rentTypeId : {id : 2, name : 'month'},
  //   facilityTypeId : {id : 1, name: 'room'},
  //   standardRoom : 'normal',
  //   descriptionOtherConvenience : 'có lò nướng',
  //   poolArea : 41,
  //   numberOfFloods : 4 ,
  //   facilityFree : 'tiger beer',
  //   img : 'https://furamavietnam.com/wp-content/uploads/2018/08/DSC08265-1047x563.jpg'
  // }
  // ];
  // constructor() { }
  // getAll() {
  //   return this.facilitys;
  // }
  // saveFacility(facility) {
  //   this.facilitys.push(facility);
  // }
  // findById(id: number) {
  //   return this.facilitys.find(facility => facility.id === id);
  // }
  // deleteFacility(id: number) {
  //   for (let i = 0; i < this.facilitys.length; i++) {
  //     if (this.facilitys[i].id === id) {
  //       this.facilitys.splice(i, 1);
  //     }
  //   }
  // }
  // updateFacility(facility) {
  //   this.facilitys.find(f => f.id === facility.id).name = facility.name;
  //   this.facilitys.find(f => f.id === facility.id).area = facility.area;
  //   this.facilitys.find(f => f.id === facility.id).cost = facility.cost;
  //   this.facilitys.find(f => f.id === facility.id).maxPeople = facility.maxPeople;
  //   this.facilitys.find(f => f.id === facility.id).rentTypeId = facility.rentTypeId;
  //   this.facilitys.find(f => f.id === facility.id).facilityTypeId = facility.facilityTypeId;
  //   this.facilitys.find(f => f.id === facility.id).descriptionOtherConvenience = facility.descriptionOtherConvenience;
  //   this.facilitys.find(f => f.id === facility.id).poolArea = facility.poolArea;
  //   this.facilitys.find(f => f.id === facility.id).numberOfFloods = facility.numberOfFloods;
  //   this.facilitys.find(f => f.id === facility.id).facilityFree = facility.facilityFree;
  //   this.facilitys.find(f => f.id === facility.id).standardRoom = facility.standardRoom;
  //   this.facilitys.find(f => f.id === facility.id).img = facility.img;
  // }
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Facility[]> {
    return this.http.get<Facility[]>(API_URL + '/facility');
  }

  saveFacility(facility): Observable<Facility> {
    return this.http.post<Facility>(API_URL + '/facility', facility);
  }

  findById(id: number): Observable<Facility> {
    return this.http.get<Facility>(`${API_URL}/facility/${id}`);
  }
  editFacility(id: number, facility: Facility): Observable<Facility>{
    return this.http.put<Facility>(`${API_URL}/facility/${id}`, facility);
  }
}
