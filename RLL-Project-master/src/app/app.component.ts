import { Component, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/services/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'inventorymanagementsyatem';

  username:string='';

  constructor(private rout:Router, private userService: UserService){
    userService.userBehavior.subscribe(val=>{
      this.username = val;
    })
  }
  logout()
  {
    this.userService.userBehavior.next('');
    localStorage.removeItem('username');
    this.rout.navigate(['/']);
  }


}
