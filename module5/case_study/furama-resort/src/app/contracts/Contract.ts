
import {Facility} from '../facilitys/Facility';
import {Customer} from '../customers/customer';

export interface Contract {
  id ?: number;
  code ?: string;
  customerId ?: Customer;
  facilityId ?: Facility;
  dayStart ?: string;
  dayEnd ?: string;
  deposit ?: number;
}
