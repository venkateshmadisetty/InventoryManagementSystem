import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  alertbar()
  {
    alert('Purchase Added Sucessfully !!')
    // this.snackbar.open('Purchase Added Succefully','close')
  }
}
