import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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
  ngOnInit(): void {
    
  }

  onSubmit(){
    if(this.createForm.valid){
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
    else{
      console.log("invalid form");
      
      alert("Mandatory Fields should be filled");
    }
    
   }

   onCancel(){

    console.log("Inside onCancel");
    this.currentChildComponent=SupplierhomeComponent;

    this.saveToggle=false;
   }

  }
