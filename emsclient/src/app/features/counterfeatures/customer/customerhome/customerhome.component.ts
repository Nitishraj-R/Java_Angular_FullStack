import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Customer } from 'src/app/features/model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customerhome',
  templateUrl: './customerhome.component.html',
  styleUrls: ['./customerhome.component.css']
})
export class CustomerhomeComponent {

  customer:Customer[]=[];
  columns:string[]=[];
  
  constructor(private http:HttpClient,private customerService : CustomerService){
    // this.customer=[
    //   {id:1,registrationNo:"",vendorName:"Nitishraj R",status:"",address:"",phoneNumber:"",emailAddress:"nit@gmail.com",shippingCost:0,tax:"",vendorCode:"",paymentTerm:"",createdBy:"",createdDate:new Date(),modifiedBy:"",lastmodifiedDate:new Date(),rmaPolicy:0,adminEmailId:"",primaryContactNumber:"",secondaryContactNumber:""},
    //   {id:2,registrationNo:"",vendorName:"Ivin R",status:"",address:"",phoneNumber:"",emailAddress:"ivin@gmail.com",shippingCost:0,tax:"",vendorCode:"",paymentTerm:"",createdBy:"",createdDate:new Date(),modifiedBy:"",lastmodifiedDate:new Date(),rmaPolicy:0,adminEmailId:"",primaryContactNumber:"",secondaryContactNumber:""}
    // ]

    this.columns=[
      "id","customerCode","email","status","firstName","lastName"
    ]
  }

  ngOnInit(): void {
    
    this.customerService.fetchAllCustomers().subscribe((res:any)=>{
      console.log("res->",res);
      if(res){
        
        for (let index = 0; index < res.length; index++) {
          this.customer.push(res[index]);
          
        }
        console.log("customer->",this.customer);
        
        
        
      }
    })
  }
}
