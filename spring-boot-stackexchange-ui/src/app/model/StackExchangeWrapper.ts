import {StackExchangeItem} from "./StackExchangeItem";

export class StackExchangeWrapper {
  items: StackExchangeItem[];
  has_more: boolean;
  error_message: string;
}
