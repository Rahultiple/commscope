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
import { AgGridModule } from 'ag-grid-angular';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import {GridButtonsComponent} from './exceptionCrud/gridButtons.component';
import { AddExcelRowComponent } from './add-excel-modal-row/add-excel-modal-row.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ExceptionCrudService } from './exceptionCrudService/exception-crud.service';
import { ExceptionCrudComponent } from './exceptionCrud/exceptionCrud.component';

@NgModule({
   declarations: [
      AppComponent,
      HeaderComponent,
      FooterComponent,
      ExceptionCrudComponent,
      GridButtonsComponent,
      AddExcelRowComponent
     ],
   imports: [
      AgGridModule.withComponents([GridButtonsComponent]),
      BrowserModule,
      AppRoutingModule,
      HttpClientModule,
      Select2Module,
      FormsModule,
      BsDatepickerModule.forRoot(),
      ReactiveFormsModule,
      NgbModule
   ],
   exports: [
    FormsModule,
    ReactiveFormsModule
  ],
   providers: [
      DataFetchService,
      ExceptionCrudService
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
