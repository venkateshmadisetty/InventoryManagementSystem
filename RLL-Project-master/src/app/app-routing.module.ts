import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemComponent } from './item/item.component';
import { LoginComponent } from './login/login.component';
import { PurchaseComponent } from './purchase/purchase.component';
import { RegisterComponent } from './register/register.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { SaleComponent } from './sale/sale.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  
    {path:'',redirectTo:'',component:WelcomeComponent,pathMatch:'full'},
    {path:'login',component:LoginComponent},
    {path:'register',component:RegisterComponent},
    {path:'item',component:ItemComponent},
    {path:'purchase',component:PurchaseComponent},
    {path:'sale',component:SaleComponent},
    {path:'customer',component:CustomerComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
