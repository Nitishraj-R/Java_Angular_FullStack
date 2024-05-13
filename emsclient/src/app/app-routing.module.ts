import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FeaturesComponent } from './features/featureshome/features/features.component';
import { CreatecustomerComponent } from './features/counterfeatures/customer/createcustomer/createcustomer.component';
import { TablerenderComponent } from './features/counterfeatures/customer/tablerender/tablerender.component';
import { DetailPageComponent } from './features/counterfeatures/supplier/detail-page/detail-page.component';
import { SupplierhomeComponent } from './features/counterfeatures/supplier/supplierhome/supplierhome.component';
import { GeneralTableComponent } from './features/counterfeatures/supplier/general-table/general-table.component';
import { CreatesupplierComponent } from './features/counterfeatures/supplier/createsupplier/createsupplier.component';
import { LoginComponent } from './features/login/login.component';
import { ConfigbomComponent } from './features/counterfeatures/configbom/configbom.component';
import { DashboardComponent } from './features/counterfeatures/dashboard/dashboard.component';
import { CustomerhomeComponent } from './features/counterfeatures/customer/customerhome/customerhome.component';
import { ProducthomeComponent } from './features/counterfeatures/product/producthome/producthome.component';
import { ProductdatatableComponent } from './features/counterfeatures/product/productdatatable/productdatatable.component';
import { ProductDetailPageComponent } from './features/counterfeatures/product/product-detail-page/product-detail-page.component';
import { CreateProductComponent } from './features/counterfeatures/product/create-product/create-product.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full' },
  {path:'login',component:LoginComponent},

  {path:'customersignup',component:CreatecustomerComponent},
  {path:'tablerender',component:CreatecustomerComponent},
  {path:'configbom',component:ConfigbomComponent},
  
  {path:'features',component:FeaturesComponent,children: [
    // { path: '', redirectTo: 'tablerender', pathMatch: 'full' },
    {path:'tablerender',component:TablerenderComponent},
    {path:'createcustomer',component:CreatecustomerComponent},
    {path:'detailPage',component:DetailPageComponent},
    {path:'supplierhome',component:SupplierhomeComponent},
    {path:'generalTable',component:GeneralTableComponent},
    {path:'createsupplier',component:CreatesupplierComponent},
    {path:'dashboard',component:DashboardComponent},
    {path:'customerHome',component:CustomerhomeComponent},
    {path:'producthome',component:ProducthomeComponent},
    {path:'createProduct',component:CreateProductComponent},
    {path:'productDatatable',component:ProductdatatableComponent},
    {path:'productDetailPage',component:ProductDetailPageComponent},



    
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
