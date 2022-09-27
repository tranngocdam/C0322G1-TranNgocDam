import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentType} from '../RentType';
import {FacilityType} from '../FacilityType';
import {FacilityService} from '../facility.service';
import {RentTypeService} from '../rent-type.service';
import {FacilityTypeService} from '../facility-type.service';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  rentTypes: RentType[] = [];
  facilityTypes: FacilityType[] = [];
  facilityForm: FormGroup = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.pattern('^[A-Z]{1,}$')]),
    area: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{2,}$')]),
    cost: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{2,}$')]),
    maxPeople: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{1,}$')]),
    rentType: new FormControl('', [Validators.required]),
    facilityType: new FormControl('', [Validators.required]),
    standardRoom: new FormControl('', [Validators.required]),
    descriptionOtherConvenience: new FormControl('', [Validators.required]),
    poolArea: new FormControl('', [Validators.required]),
    numberOfFloods: new FormControl('', [Validators.required]),
    facilityFree: new FormControl('', [Validators.required]),
    img: new FormControl('', [Validators.required])
  });

  constructor(private facilityService: FacilityService,
              private rentTypeService: RentTypeService,
              private facilityTypeService: FacilityTypeService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllRentType();
    this.getAllFacilityType();
  }

  submit() {
    const facility = this.facilityForm.value;
    this.rentTypeService.findById(facility.rentType).subscribe(rentType => {
        this.facilityTypeService.findById(facility.facilityType).subscribe(facilityType => {
            facility.rentType = {
              id: rentType.id,
              name: rentType.name
            };
            facility.facilityType = {
              id: facilityType.id,
              name: facilityType.name
            };

            this.facilityService.saveFacility(facility).subscribe(() => {
              alert('Thành công');
              this.facilityForm.reset();
              this.router.navigateByUrl('facilitys/facility-list');
            }, e => console.log(e));
          }
        );

      }
    );

  }

  getAllRentType() {
    this.rentTypeService.getAll().subscribe(rentTypes => {
      this.rentTypes = rentTypes;
    });
  }

  getAllFacilityType() {
    this.facilityTypeService.getAll().subscribe(facilitytypes => {
      this.facilityTypes = facilitytypes;
    });
  }
}
