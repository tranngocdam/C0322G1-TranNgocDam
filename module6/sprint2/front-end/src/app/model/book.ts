import {Category} from './category';
import {Company} from './company';
import {Discount} from './discount';

export interface Book {
  id?: number;
  name?: string;
  code?: string;
  createDate?: string;
  size?: string;
  description?: string;
  author?: string;
  price?: number;
  amount?: number;
  image?: string;
  numberOfPage?: number;
  status?: boolean;
  category?: Category;
  company?: Company;
  discount?: Discount;
}
