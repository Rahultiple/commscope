import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ExceptionCrudComponent } from './exceptionCrud/exceptionCrud.component';
const routes: Routes = [

  { path: "searchForm", component: ExceptionCrudComponent },
  {
    path: "",
    component: ExceptionCrudComponent

  },
  {
    path: "",
    component: HeaderComponent,
    outlet: "upperbar"
  },

   {
    path: "",
    component: FooterComponent,
    outlet: "footerbar"

  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
