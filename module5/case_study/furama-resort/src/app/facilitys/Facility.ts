import {RentType} from './RentType';
import {FacilityType} from './FacilityType';

export interface Facility {
  id ?: number;
  name ?: string;
  area ?: string;
  cost ?: string;
  maxPeople ?: number;
  rentType ?: RentType;
  facilityType ?: FacilityType;
  standardRoom ?: string;
  descriptionOtherConvenience ?: string;
  poolArea ?: number;
  numberOfFloods ?: number;
  facilityFree ?: string;
  img ?: string;
}
