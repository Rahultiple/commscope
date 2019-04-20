import { SearchAuditComponent } from './searchAudit/searchAudit.component';
import { BiddingComponent } from './bidding/bidding.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ProductlistSidebarComponent } from './productlist-sidebar/productlist-sidebar.component';
import { FooterComponent } from './footer/footer.component';
import { DetailInputComponent } from './detail-input/detail-input.component';
const routes: Routes = [
  { path: "products", component: DashboardComponent },
  { path: "product/:id", component: ProductDetailComponent },
  { path: "details",    component: DetailInputComponent },
  { path: "bidding",    component: BiddingComponent },
  { path: "searchForm", component: SearchAuditComponent },
  {
    path: "",
    component: LoginComponent

  },
  {
    path: "",
    component: HeaderComponent,
    outlet: "upperbar"
  },
  {
    path: "products",
    component: ProductlistSidebarComponent,
    outlet: "sidebar"
  },
  {
    path: "dashboard",
    component: DashboardComponent

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
