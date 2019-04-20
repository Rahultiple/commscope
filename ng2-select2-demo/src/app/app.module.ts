import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { Select2Module } from 'ng2-select2';

import { AppComponent } from './app.component';

import { DataService } from '../services/data.service';

import { BasicComponent } from './demos/basic/basic.component';
import { TemplateComponent } from './demos/template/template.component';
import { DynamicComponent } from './demos/dynamic/dynamic.component';
import { OptionsComponent } from './demos/options/options.component';
import { ChangeComponent } from './demos/change/change.component';
import { MatcherComponent } from './demos/matcher/matcher.component';
import { MultipleComponent } from './demos/multiple/multiple.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    BasicComponent,
    ChangeComponent,
    DynamicComponent,
    OptionsComponent,
    TemplateComponent,
    MatcherComponent,
    MultipleComponent
  ],
  imports: [
    BrowserModule,
    Select2Module,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ DataService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
