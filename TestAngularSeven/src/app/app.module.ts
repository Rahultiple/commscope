import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule,FormGroup,FormControl } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './util/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { ProductlistSidebarComponent } from './productlist-sidebar/productlist-sidebar.component';
import { HeaderComponent } from './header/header.component';
import { DataFetchService } from './data/data-fetch.service';
import { HttpClientModule } from '@angular/common/http';
import { Select2Module } from 'ng2-select2';
import { FooterComponent } from './footer/footer.component';
import { DetailInputComponent } from './detail-input/detail-input.component';
import { BiddingComponent } from './bidding/bidding.component';
import { SearchAuditComponent } from './searchAudit/searchAudit.component';
import { AuditSearchService } from './auditSearchService/audit-search.service';
import { AgGridModule } from 'ag-grid-angular';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import { DashboardSiteComponent } from './dashboard-site/dashboard-site.component'
@NgModule({
   declarations: [
      AppComponent,
      DashboardComponent,
      LoginComponent,
      ProductDetailComponent,
      ProductlistComponent,
      ProductlistSidebarComponent,
      HeaderComponent,
      FooterComponent,
      DetailInputComponent,
      BiddingComponent,
      SearchAuditComponent,
      DashboardSiteComponent
     ],
   imports: [
      AgGridModule.withComponents(null),
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      Select2Module,
      FormsModule,
      BsDatepickerModule.forRoot(),
      ReactiveFormsModule
   ],
   exports: [
    FormsModule,
    ReactiveFormsModule
  ],
   providers: [
      DataFetchService,
      AuditSearchService
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
