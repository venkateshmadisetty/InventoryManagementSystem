import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from 'src/app/models/ItemModel';

@Injectable({
  providedIn: 'root',
})
export class ItemService {
  private regItemUrl: string =
  'http://localhost:8080/api/v1/items';
  private logCustomerUrl: string = 'http://localhost:8080/api/v1/customers';

  

  constructor(private _httpClient: HttpClient) {}

  registerItem(item: Item): any {
    return this._httpClient.post<Item>(this.regItemUrl, item);
  }
}
