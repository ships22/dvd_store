import { CartService } from './service/cart.service';
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { DISPLAYComponent } from "./DVD/display/display.component";
import { HttpClientModule } from "@angular/common/http";
import { HeaderComponent } from "./header/header.component";

import { ManageStoreComponent } from "./DVD/manage-store/manage-store.component";
import { ProductComponent } from "./admin/product/product.component";
import { CheckoutComponent } from './DVD/display/checkout/checkout.component';
import { EditDvdComponent } from './admin/product/edit-dvd/edit-dvd.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';




@NgModule({
  declarations: [
    AppComponent,
    DISPLAYComponent,
    HeaderComponent,

    ManageStoreComponent,
    ProductComponent,
    CheckoutComponent,
    EditDvdComponent,
    LoginComponent,
    LogoutComponent,


  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
