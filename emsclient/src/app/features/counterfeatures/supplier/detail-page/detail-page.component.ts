import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonService } from '../../service/common.service';
import { Router } from '@angular/router';
import { SupplierhomeComponent } from '../supplierhome/supplierhome.component';
import { SupplierService } from '../service/supplier.service';

@Component({
  selector: 'app-detail-page',
  templateUrl: './detail-page.component.html',
  styleUrls: ['./detail-page.component.css']
})
export class DetailPageComponent implements OnInit{


 currentChildComponent: any = null;
  updateForm:FormGroup;
  constructor(private http:HttpClient,private builder:FormBuilder,private commonService:CommonService,private router:Router,private supplierService:SupplierService){
    this.updateForm=this.builder.group({
      id:[''],
      vendorName:[''],
      registrationNo:[''],
      status:Boolean,
      address:[''],
      emailAddress:['',[Validators.email]],
      shippingCost:[''],
      tax:[''],
      vendorCode:[''],
      paymentTerm:[''],
      rmaPolicy:[''],
      adminEmailId:['',[Validators.email]],
      primaryContactNumber:['',[Validators.pattern("[8-9]{1}[0-9]{9}")]],
      secondaryContactNumber:['',[Validators.pattern("[8-9]{1}[0-9]{9}")]]
    })
  }
  columns:string[]=["sd","sf"];
  data:any;
  update:boolean=true;
 
  employeeDetailsArray:[string, unknown][]=[];
  // employee=new Employee();
 
  // employeeDetailsArray = [];
  ngOnInit(): void {
    
  // this.supplierService.fetchAllSupplier().subscribe(res=>{
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
    
    this.supplierService.deleteSupplier(this.updateForm.value.vendorCode).subscribe((res:string)=>{
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
    this.currentChildComponent=SupplierhomeComponent;

    // this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
    //   this.router.navigate([this.router.url]);
    // });
    })
    
   }

   formChange(){
  //   if(this.updateForm.valid){
  //   this.supplierService.updateSupplier(this.updateForm.value).subscribe((res:any)=>{
  //   if(res!=null){
  //     console.log("Inside formchange");
  //     console.log("res->",res);
      
  //     this.updateForm.patchValue(res);
  //     alert("Updated Successful");
  //     console.log("updateForm.value",this.updateForm.value);
  //     this.currentChildComponent=SupplierhomeComponent;
 
  //   }
  //   })
  // }
  // else{
  //   alert("Mandatory fields should be filled")
  // }


  //   this.supplierService.fetchByVendorCode(this.updateForm.value.vendorCode).subscribe((res:any)=>{
  //   if(res!=null){
  //     console.log("Inside formchange");
  //     console.log("res->",res);
      
  //     this.updateForm.patchValue(res);
  //     // alert("Updated Succesful");
  //     console.log("updateForm.value",this.updateForm.value);
  //     // this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
  //     //   this.router.navigate([this.router.url]);
  //     // });
      
  //     // this.update=true;this.router.navigate(['/features/supplierhome']);
  //     this.currentChildComponent=SupplierhomeComponent;

 
  //   }
  //   })
    // this.location.reload();
    // window.location.reload();
 
   }
   
 
   onSubmit(){
    if(this.updateForm.valid){
    this.supplierService.updateSupplier(this.updateForm.value).subscribe((res:any)=>{
    if(res!=null){
      console.log("Inside formchange");
      console.log("res->",res);
      
      this.updateForm.patchValue(res);
      alert("Updated Successful");
      console.log("updateForm.value",this.updateForm.value);
      this.currentChildComponent=SupplierhomeComponent;
 
    }
    })
  }
  else{
    alert("Mandatory fields should be filled")
  }
   }

   onCancel(){

    console.log("Inside onCancel");
    this.currentChildComponent=SupplierhomeComponent;

   }

   onBack(){

    console.log("Inside onBack");
    this.currentChildComponent=SupplierhomeComponent;

   }
}
