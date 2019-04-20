import { SearchAuditComponent } from './searchAudit/searchAudit.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
const routes: Routes = [

  { path: "searchForm", component: SearchAuditComponent },
  {
    path: "",
    component: SearchAuditComponent

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
