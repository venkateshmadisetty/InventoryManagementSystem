import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  alertbar()
  {
    alert('Sale Added Sucessfully !!')
    // this.snackbar.open('Sale Added Succefully','close')
  }
}
