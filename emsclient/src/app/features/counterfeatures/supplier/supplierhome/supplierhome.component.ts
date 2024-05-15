import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Supplier } from 'src/app/features/model/supplier';
import { SupplierService } from '../service/supplier.service';

@Component({
  selector: 'app-supplierhome',
  templateUrl: './supplierhome.component.html',
  styleUrls: ['./supplierhome.component.css']
})
export class SupplierhomeComponent implements OnInit{


  supplier:Supplier[]=[];
  columns:string[]=[];
  
  constructor(private http:HttpClient,private supplierService : SupplierService){
    // this.vendor=[
    //   {id:1,registrationNo:"",vendorName:"Nitishraj R",status:"",address:"",phoneNumber:"",emailAddress:"nit@gmail.com",shippingCost:0,tax:"",vendorCode:"",paymentTerm:"",createdBy:"",createdDate:new Date(),modifiedBy:"",lastmodifiedDate:new Date(),rmaPolicy:0,adminEmailId:"",primaryContactNumber:"",secondaryContactNumber:""},
    //   {id:2,registrationNo:"",vendorName:"Ivin R",status:"",address:"",phoneNumber:"",emailAddress:"ivin@gmail.com",shippingCost:0,tax:"",vendorCode:"",paymentTerm:"",createdBy:"",createdDate:new Date(),modifiedBy:"",lastmodifiedDate:new Date(),rmaPolicy:0,adminEmailId:"",primaryContactNumber:"",secondaryContactNumber:""}
    // ]

    this.columns=[
      "vendorCode","registrationNo","vendorName","emailAddress","primaryContactNumber"
    ]
  }

  ngOnInit(): void {
    
    this.supplierService.fetchAllSupplier().subscribe((res:any)=>{
      console.log("res->",res);
      if(res){
        
        for (let index = 0; index < res.length; index++) {
          this.supplier.push(res[index]);
          
        }
        console.log("supplier->",this.supplier);
        
        
        
      }
    })
  }
}
