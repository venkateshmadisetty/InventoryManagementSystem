import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/services/users.service';
import { RegUser } from '../models/RegistrationModel';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UserService) { }
  name:string='';
  username:string='';
  password:string='';
  confpassword:string='';
  ngOnInit(): void {
  }
  reg()
  {
    console.log(this.name);
    const regUser = new RegUser();
    regUser.name = this.name;
    regUser.password = this.password;
    regUser.username = this.username;

    this.userService.registerCustomer(regUser).subscribe((resp:any)=>{
      alert(" Registered Successfully !!"+ resp);
    })

  }

}
