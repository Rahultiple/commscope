import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule,FormGroup,FormControl } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DataFetchService } from './data/data-fetch.service';
import { HttpClientModule } from '@angular/common/http';
import { Select2Module } from 'ng2-select2';
import { FooterComponent } from './footer/footer.component';
import { SearchAuditComponent } from './searchAudit/searchAudit.component';
import { AuditSearchService } from './auditSearchService/audit-search.service';
import { AgGridModule } from 'ag-grid-angular';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker'
@NgModule({
   declarations: [
      AppComponent,
      HeaderComponent,
      FooterComponent,
      SearchAuditComponent
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
