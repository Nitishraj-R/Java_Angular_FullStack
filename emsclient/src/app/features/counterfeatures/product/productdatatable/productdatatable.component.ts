import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ProductdatatableDataSource } from './productdatatable-datasource';
import { ProductDetailPageComponent } from '../product-detail-page/product-detail-page.component';
import { DatatableDataSource } from '../../datatable/datatable/datatable-datasource';
import { DataService } from '../../service/dataservice';
import { Router } from '@angular/router';
import { CreateProductComponent } from '../create-product/create-product.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-productdatatable',
  templateUrl: './productdatatable.component.html',
  styleUrls: ['./productdatatable.component.css']
})
export class ProductdatatableComponent implements AfterViewInit,OnInit{
 
    @Input() columns: any[] = [];
    currentChildComponent:any=null;
    url = 'http://localhost:8080/wms/product/api/getAllProducts';
 

    constructor(private dataService:DataService,private route:Router,private http:HttpClient){}
   
    ngOnInit(): void {
     
      console.log("columns []",this.columns);
      for (let index = 0; index < this.columns.length; index++) {
        this.displayedColumns.push(this.columns[index].FieldValue);
       
      }
      console.log('displayedColumns',this.getDisplayedColumns());
   
      console.log('column',this.columns);
   
     
     
     
    }
    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;
    @ViewChild(MatTable) table!: MatTable<any>;
    dataSource = new DatatableDataSource(this.dataService);
   
   
    /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
    displayedColumns:any []= this.columns;
   
    getDisplayedColumns(){
      return this.displayedColumns;
    }
   
      ngAfterViewInit(): void {
      console.log("Datasource",this.dataSource);
     
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.dataSource.columns=this.displayedColumns;
      this.table.dataSource = this.dataSource;
    }
   
   
    detailPage(rowData:any){
    console.log("rowData",rowData);
    this.dataService.setRowData(rowData);
   
    // this.route.navigate(['/features/details']);
    this.currentChildComponent=ProductDetailPageComponent;
    console.log(this.currentChildComponent);
   
   
    }

    loadpage(){
      console.log("load page");
      this.http.get<any[]>(this.url)
      .subscribe(data => {
        if(data){
          console.log("data->",data);
          
      this.dataService.setSharedData(data);
        }
    })

    }

    // ngOnChanges() {
    //   console.log('ngOnChanges called');
    //   this.http.get<any[]>(this.url)
    //   .subscribe(data => {
    //     if(data){
    //       console.log("data->",data);
          
    //   this.dataService.setSharedData(data);
    //     }
    // })
    // }
    
    // ngDoCheck() {
    //   console.log('ngDoCheck called');
      
    // }
  
    // ngAfterContentInit() {
    //   console.log('ngAfterContentInit called');
    // }
  
    // ngAfterContentChecked() {
    //   console.log('ngAfterContentChecked called');
      
    // }
  
   
  
    // ngAfterViewChecked() {
    //   console.log('ngAfterViewChecked called');
    // }
  
    // ngOnDestroy() {
    //   console.log('ngOnDestroy called');
    // }
  

    goToCreate(){
      console.log("Inside Create");
       
          // this.router.navigateByUrl('/createProduct');
          this.currentChildComponent=CreateProductComponent;
       
       }
  }