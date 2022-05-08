
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { RegUser } from 'src/app/models/RegistrationModel';
import { Customer } from 'src/models/customer';

@Injectable({
    providedIn: 'root',
})
export class UserService {
    private customerLoggedIn:any;
    private regCustomerUrl: string =
        'http://localhost:8080/api/v1/users';
    private logCustomerUrl: string = 'http://localhost:8080/api/v1/users';
    loggedInusername:string='';
    userBehavior = new BehaviorSubject<string>('');



    constructor(private _httpClient: HttpClient) { }

    registerCustomer(customer: RegUser): any {
        return this._httpClient.post<RegUser>(this.regCustomerUrl, customer);
    }

    validateCustomer(value: any) {
        return this._httpClient.post<Customer>(this.logCustomerUrl, value);
    }

    setCustomerLoggedIn(customerLoggedIn: string) {
        this.customerLoggedIn = customerLoggedIn;
    }
    getCustomerLoggedIn() {
        return this.customerLoggedIn;
    }

    login(user:RegUser){
        return this._httpClient.post(this.regCustomerUrl+'/login',user);
    }
}