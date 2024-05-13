import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommonService } from '../../service/common.service';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';
import { CustomerhomeComponent } from '../customerhome/customerhome.component';

@Component({
  selector: 'app-customer-detail-page',
  templateUrl: './customer-detail-page.component.html',
  styleUrls: ['./customer-detail-page.component.css']
})
export class CustomerDetailPageComponent {

  currentChildComponent: any = null;
  updateForm:FormGroup;
  constructor(private http:HttpClient,private builder:FormBuilder,private commonService:CommonService,private router:Router,private customerService:CustomerService){
    this.updateForm=this.builder.group({
      id:[''],
      customerCode:[''],
      title:[''],
      status:Boolean,
      firstName:[''],
      lastName:[''],
      midddleName:[''],
      gender:[''],
      email:[''],
      mobileNum:[''],
      phoneNum:[''],
      dob:[],
      source:[''],
      defaultPaymentGateway:['']
    })
  }
  columns:string[]=["sd","sf"];
  data:any;
  update:boolean=true;
 
  
  ngOnInit(): void {
    
  // this.customerService.fetchAllCustomers().subscribe(res=>{
  //   console.log("res->",res);
    
  // })
  this.commonService.commonmsg.subscribe(m=>{
    console.log("m->",m);
    this.data=m;
    this.updateForm.patchValue(this.data);
  })
  this.commonService.commonmsg.subscribe(m=>{
    console.log("m->",m);
    // this.columns=m;
  })
 
   
   }
 
   onEdit(){
        this.update=false;
        console.log("inside edit");
       
   }
   onDelete(){

    console.log("inside delete method");
    
    this.customerService.deleteCustomer(this.updateForm.value.customerCode).subscribe((res:any)=>{
    if(!res){
      console.log("Inside onDelete method");
      console.log("res->",res);
      alert("deleted Successful");
      
      // this.update=true;
 
    }
    else{
      console.log("res->",res);
      alert("not deleted");
    }
    // this.router.navigate(['/features/supplierhome']);
    this.currentChildComponent=CustomerhomeComponent;

    // this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
    //   this.router.navigate([this.router.url]);
    // });
    })
    
   }

   formChange(){
    
    this.customerService.updateCustomer(this.updateForm.value).subscribe((res:any)=>{
    if(res!=null){
      console.log("Inside formchange");
      console.log("res->",res);
      
      this.updateForm.patchValue(res);
      alert("Updated Successful");
      console.log("updateForm.value",this.updateForm.value);
      
 
    }
    })

    this.customerService.fetchByCustomerCode(this.updateForm.value.customerCode).subscribe((res:any)=>{
    if(res!=null){
      console.log("Inside formchange");
      console.log("res->",res);
      
      this.updateForm.patchValue(res);
      // alert("Updated Succesful");
      console.log("updateForm.value",this.updateForm.value);
      // this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      //   this.router.navigate([this.router.url]);
      // });
      
      // this.update=true;this.router.navigate(['/features/supplierhome']);
      this.currentChildComponent=CustomerhomeComponent;

 
    }
    })
    // this.location.reload();
    // window.location.reload();
 
   }
   
 
   onSubmit(){
    
    console.log("this.updateForm.value",this.updateForm.value);
    this.update=true;
   }
}
