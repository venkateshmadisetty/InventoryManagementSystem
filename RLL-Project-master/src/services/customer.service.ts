import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from 'src/models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private regCustomerUrl: string = 'http://localhost:8080/api/v1/customers';
  private logCustomerUrl: string = 'http://localhost:8080/api/v1/customers';

  constructor(private _httpClient: HttpClient) {}

  registerCustomer(customer: Customer): any {
    // alert('registering customer');
    return this._httpClient.post<Customer>(this.regCustomerUrl, customer);
  }

  validateCustomer(value: any) {
    return this._httpClient.post<Customer>(this.logCustomerUrl, value);
  }

  // setCustomerLoggedIn(customerLoggedIn: string) {
  //   this.customerLoggedIn = customerLoggedIn;
  // }
  // getCustomerLoggedIn() {
  //   return this.customerLoggedIn;
  // }
}
