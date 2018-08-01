import { TransactionsService } from './services/transactions.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { CardModule } from 'ngx-card/ngx-card';
import { AppComponent } from './app.component';
import { CreditCardComponent } from './components/credit-card/credit-card.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { FilesComponent } from './components/files/files.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { approutes } from './routing';
import { RouterModule } from '@angular/router';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import {
  faSearch,
  faShoppingCart,
  faMoneyBillAlt
} from '@fortawesome/free-solid-svg-icons';
import { ItemsComponent } from './components/items/items.component';
import { ItemsListComponent } from './components/items/items-list/items-list.component';
import { ItemDetailComponent } from './components/items/item-detail/item-detail.component';
import { CardService } from './services/card.service';
import { ProfileComponent } from './components/profile/profile.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { ItemCheckoutComponent } from './components/items/item-checkout/item-checkout.component';
import { CookieService } from 'ngx-cookie-service';
import { ItemSubmitComponent } from './components/items/item-submit/item-submit.component';

library.add(faShoppingCart, faSearch, faMoneyBillAlt);

@NgModule({
  declarations: [
    AppComponent,
    CreditCardComponent,
    LoginComponent,
    FilesComponent,
    NavbarComponent,
    ItemsComponent,
    ItemsListComponent,
    ItemDetailComponent,
    ProfileComponent,
    TransactionsComponent,
    ItemCheckoutComponent,
    ItemSubmitComponent
  ],
  imports: [
    BrowserModule,
    CardModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    RouterModule.forRoot(approutes)
  ],
  providers: [
    LoginService,
    CardService,
    TransactionsService,
    CookieService,
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}