import {AppUser} from './app-user';

export interface Customer {
  id ?: number;
  name ?: string;
  dayOfBirth ?: string;
  address ?: string;
  gender ?: boolean;
  phone ?: number;
  email ?: string;
  status ?: boolean;
  appUsers ?: AppUser;
}
