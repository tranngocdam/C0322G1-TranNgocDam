import {Customer} from './customer';

export interface AppUser {
id ?: number;
username ?: string;
password ?: string;
email ?: string;
createDate ?: string;
status ?: boolean;
customer ?: Customer;
}
