import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FeaturesComponent } from './features/featureshome/features/features.component';
import { UserprofileComponent } from './features/header/userprofile/userprofile.component';
import { ListofassetsComponent } from './features/header/listofassets/listofassets.component';
import { SearchbarComponent } from './features/header/searchbar/searchbar.component';
import { AssetlistComponent } from './features/header/assetlist/assetlist.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreatecustomerComponent } from './features/counterfeatures/customer/createcustomer/createcustomer.component';
import { TablerenderComponent } from './features/counterfeatures/customer/tablerender/tablerender.component';
import { ProducthomeComponent } from './features/counterfeatures/product/producthome/producthome.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DatatableComponent } from './features/counterfeatures/datatable/datatable/datatable.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { TableComponent } from './table/table.component';
import { CreatesupplierComponent } from './features/counterfeatures/supplier/createsupplier/createsupplier.component';
import { SupplierhomeComponent } from './features/counterfeatures/supplier/supplierhome/supplierhome.component';
import { GeneralTableComponent } from './features/counterfeatures/supplier/general-table/general-table.component';
import { DetailPageComponent } from './features/counterfeatures/supplier/detail-page/detail-page.component';
import { LoginComponent } from './features/login/login.component';
import { DashboardComponent } from './features/counterfeatures/dashboard/dashboard.component';
import { CustomerhomeComponent } from './features/counterfeatures/customer/customerhome/customerhome.component';
import { CustomertableComponent } from './features/counterfeatures/customer/customertable/customertable.component';
import { CustomerDetailPageComponent } from './features/counterfeatures/customer/customer-detail-page/customer-detail-page.component';
import { CreateProductComponent } from './features/counterfeatures/product/create-product/create-product.component';
import { ProductDetailPageComponent } from './features/counterfeatures/product/product-detail-page/product-detail-page.component';
import { ProductdatatableComponent } from './features/counterfeatures/product/productdatatable/productdatatable.component';
import { ConfigbomlistviewComponent } from './features/counterfeatures/configbom/configbomlistview/configbomlistview.component';
import { ConfigbomcreationComponent } from './features/counterfeatures/configbomcreation/configbomcreation.component';
import { TitleCasePipe } from './service/title-case.pipe';
import { ProducttableComponent } from './features/counterfeatures/product/producttable/producttable.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    FeaturesComponent,
    UserprofileComponent,
    SearchbarComponent,
    ListofassetsComponent,
    AssetlistComponent,
    CreatecustomerComponent,
    TablerenderComponent,
    ProducthomeComponent,
    DatatableComponent,
    TableComponent,
    CreatesupplierComponent,
    SupplierhomeComponent,
    GeneralTableComponent,
    DetailPageComponent,
    LoginComponent,
    DashboardComponent,
    ConfigbomcreationComponent,
    CustomerhomeComponent,
    CustomertableComponent,
    CustomerDetailPageComponent,
    CreateProductComponent,
    ProductDetailPageComponent,
    ProductdatatableComponent,
    ConfigbomlistviewComponent,
    ConfigbomcreationComponent,
    TitleCasePipe,
    ProducttableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    NgbModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
   
   
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
