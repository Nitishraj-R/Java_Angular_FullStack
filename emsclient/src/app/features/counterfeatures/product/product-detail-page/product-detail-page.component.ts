import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProducthomeComponent } from '../producthome/producthome.component';
import { DataService } from '../../service/dataservice';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product-detail-page',
  templateUrl: './product-detail-page.component.html',
  styleUrls: ['./product-detail-page.component.css']
})
export class ProductDetailPageComponent implements OnInit,AfterViewInit{
    rowData:any;
    @ViewChild('rowDiv') rowDiv!:ElementRef;
   
    currentChildComponent: any = null;
   
    constructor(private dataService:DataService,private http:HttpClient){}
  ngOnInit(): void {
   
      this.rowData=this.dataService.getRowData();
      console.log("rowDataDetailComponent",this.rowData);
     
  }
   
  ngAfterViewInit(): void {
      console.log("ngAfterViewInit method is called");
   
      // console.log(this.rowDiv.nativeElement.value.productId);
     
     
     
  }
   
  deleteRecord(){
    console.log("inside Delete Method");
   
    let id=this.rowData.productId;
    console.log("ID",id);
    console.log('http://localhost:8080/wms/product/api/deleteProduct?productId='+id);
   
   
     this.http.delete('http://localhost:8080/wms/product/api/deleteProduct?productId='+id).subscribe(res=>{
      console.log(res);
     });
     this.currentChildComponent=ProducthomeComponent;
   
  }

  
   
   
   
  }