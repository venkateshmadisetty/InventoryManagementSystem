import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/services/item.service';
import { Item } from '../models/ItemModel';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  constructor(private itemService: ItemService) { }

  itemNumber:number=0;
  productId:number=0;
  itemName:string='';
  desc:string='';
  status:number=0;
  discount:number=0;
  quantity:number=0;
  unitPrice:number=0;
  totalStock:number=0;

  ngOnInit(): void {
  }
  addItem()
  {
    const item = new Item();
    item.itemName = this.itemName;
    item.itemNumber = this.itemNumber;
    item.productId = this.productId;
    item.quantity = this.quantity;
    // item.totalPrice = this.totalStock;
    item.totalPrice = this.quantity * this.unitPrice;
    item.unitPrice = this.unitPrice;
    item.description = this.desc;
    // item.status = this.status;

    

    this.itemService.registerItem(item).subscribe((resp:any)=>{

      alert('Item Added Sucessfully !!'+ resp)
    })
    // this.snackbar.open('Item Succefully','close')
  }
}
