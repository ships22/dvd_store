import { AuthGaurdService } from './service/auth-gaurd.service';
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { CheckoutComponent } from './DVD/display/checkout/checkout.component';
import { EditDvdComponent } from './admin/product/edit-dvd/edit-dvd.component';


import { ManageStoreComponent } from "./DVD/manage-store/manage-store.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { DISPLAYComponent } from "./DVD/display/display.component";
import { ProductComponent } from "./admin/product/product.component";

const routes: Routes = [
  { path: "display", component: DISPLAYComponent },
  { path: "admin", component: ManageStoreComponent, canActivate: [AuthGaurdService] },
  { path: "productadmin", component: ProductComponent, canActivate: [AuthGaurdService] },
  { path: "edit-dvd/:id", component: EditDvdComponent, canActivate: [AuthGaurdService] },
  { path: "cart", component: CheckoutComponent },
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent, canActivate: [AuthGaurdService] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
