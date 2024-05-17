import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataService } from '../../service/dataservice';
import { Router } from '@angular/router';
import { CreateProductComponent } from '../create-product/create-product.component';
import { Product } from 'src/app/features/model/product';
import { SupplierService } from '../../supplier/service/supplier.service';

@Component({
  selector: 'app-producthome',
  templateUrl: './producthome.component.html',
  styleUrls: ['./producthome.component.css']
})
export class ProducthomeComponent implements OnInit{
 product:Product[]=[];
  columns:string[]=[];
  url='http://localhost:8080/wms/product/api/getAllProducts';
  httpHeaders:HttpHeaders=new HttpHeaders();
  // formFields: any[] = [
  //   {Head:'SKU Number',FieldValue:'skuNumber'},
  //   {Head:'Product Id',FieldValue:'productId'},
  //   {Head:'Product Name',FieldValue:'productName'},
  //   {Head:'Description',FieldValue:'productShortDesc'},
  //   {Head:'Status',FieldValue:'status'},
  //   {Head:'Dimension',FieldValue:'dimensions'},
  //   ];

  
 
  constructor(private http:HttpClient,private supplierService : SupplierService){
    // this.vendor=[
    //   {id:1,registrationNo:"",vendorName:"Nitishraj R",status:"",address:"",phoneNumber:"",emailAddress:"nit@gmail.com",shippingCost:0,tax:"",vendorCode:"",paymentTerm:"",createdBy:"",createdDate:new Date(),modifiedBy:"",lastmodifiedDate:new Date(),rmaPolicy:0,adminEmailId:"",primaryContactNumber:"",secondaryContactNumber:""},
    //   {id:2,registrationNo:"",vendorName:"Ivin R",status:"",address:"",phoneNumber:"",emailAddress:"ivin@gmail.com",shippingCost:0,tax:"",vendorCode:"",paymentTerm:"",createdBy:"",createdDate:new Date(),modifiedBy:"",lastmodifiedDate:new Date(),rmaPolicy:0,adminEmailId:"",primaryContactNumber:"",secondaryContactNumber:""}
    // ]

    this.columns=[
      "skuNumber","productId","productName","productidType","manufacturer","category"
    ]
  }
 datatableDisplay:boolean=false;
  productData: any[] = [];
  keys:any[]=[];
   
ngOnInit(){
  this.httpHeaders = new HttpHeaders ({
    'Content-Type':'application/json',
    // 'Authorization':`Bearer ${localStorage.getItem('loginToken')}`
  })
  
  console.log("url of all product is",this.url);
 
    this.http.get<any[]>(this.url,{headers:this.httpHeaders})
      .subscribe(res => {
        if(res){
          for (let index = 0; index < res.length; index++) {
            this.product.push(res[index]);
            
          }
          console.log("product->",this.product);
        }
        else{
          console.log("res",res);
         
        }
       
       
      });
     
     
  }
  

}
