import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { SupplierhomeComponent } from '../supplierhome/supplierhome.component';
import { SupplierService } from '../service/supplier.service';

@Component({
  selector: 'app-createsupplier',
  templateUrl: './createsupplier.component.html',
  styleUrls: ['./createsupplier.component.css']
})
export class CreatesupplierComponent {

  createForm:FormGroup;

  saveToggle:boolean=true;
  currentChildComponent: any = null;

  constructor(private builder:FormBuilder,private http:HttpClient,private supplier:SupplierService){
    this.createForm=builder.group({
      id:[''],
      vendorName:[''],
      registrationNo:[''],
      status:true,
      address:[''],
      // phoneNumber:['']      phoneNumber:[''],
      emailAddress:[''],
      shippingCost:[''],
      tax:[''],
      vendorCode:[''],
      paymentTerm:[''],
      rmaPolicy:[''],
      adminEmailId:[''],
      primaryContactNumber:[''],
      secondaryContactNumber:['']
    })
  }
  ngOnInit(): void {
    
  }

  onSubmit(){
    
    this.supplier.postSupplier(this.createForm.value).subscribe((res:any)=>{
    if(res!=null){
      console.log("Inside onSubmit");
      console.log("res->",res);
      
      this.createForm.patchValue(res);
      alert("saved Successfully");
      console.log("createForm.value",this.createForm.value);
      this.currentChildComponent=SupplierhomeComponent;
      this.saveToggle=false;
 
    }
    })
   }

   onCancel(){

    console.log("Inside onCancel");
    this.currentChildComponent=SupplierhomeComponent;

    this.saveToggle=false;
   }

  }
