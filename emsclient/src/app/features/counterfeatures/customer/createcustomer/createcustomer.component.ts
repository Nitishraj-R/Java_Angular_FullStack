import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SupplierService } from '../../supplier/service/supplier.service';
import { CustomerService } from '../service/customer.service';
import { CustomerhomeComponent } from '../customerhome/customerhome.component';

@Component({
  selector: 'app-createcustomer',
  templateUrl: './createcustomer.component.html',
  styleUrls: ['./createcustomer.component.css']
})
export class CreatecustomerComponent {
 
  createForm:FormGroup;

  saveToggle:boolean=true;
  currentChildComponent: any = null;

  constructor(private builder:FormBuilder,private http:HttpClient,private customer:CustomerService){
    this.createForm=builder.group({
      id:[''],
      customerCode:[''],
      title:[''],
      status:true,
      firstName:[''],
      lastName:[''],
      midddleName:[''],
      gender:[''],
      email:[''],
      mobileNum:[''],
      phoneNum:[''],
      dob:[Date],
      source:[''],
      defaultPaymemetGateway:['']
    })
  }
  ngOnInit(): void {
    
  }

  onSubmit(){
    
    this.customer.postCustomer(this.createForm.value).subscribe((res:any)=>{
    if(res!=null){
      console.log("Inside onSubmit");
      console.log("res->",res);
      
      this.createForm.patchValue(res);
      alert("saved Successfully");
      console.log("createForm.value",this.createForm.value);
      this.currentChildComponent=CustomerhomeComponent;
      this.saveToggle=false;
 
    }
    })
   }

   onCancel(){

    console.log("Inside onCancel");
    this.currentChildComponent=CustomerhomeComponent;

    this.saveToggle=false;
   }


}
