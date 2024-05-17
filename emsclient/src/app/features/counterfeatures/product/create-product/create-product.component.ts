import { Component, OnInit } from '@angular/core';
import { ProducthomeComponent } from '../producthome/producthome.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit{
 
  createForm:FormGroup;
  
 
  saveToggle:boolean=true;
  currentChildComponent: any = null;
 
  constructor(private builder:FormBuilder,private http:HttpClient){
    this.createForm=this.builder.group({
      id:[""],
 
	skuNumber:[''],
 
	productId:[""],
 
	productidType:[""],
 
	productName:[""],
 
  productShortDesc:[""],

  manufacturer:[""],
	
	category:[""],
	
	subcategory:[""],
	
	material:[""],
	
	color:[""],
	
	compatibilityNotes:[""],
	
	warranty:[""],
 
	parentSkuId:[''],
 
	status:[''],
 
	isReturnable:[''],
 
	maxOrdQty:[''],
 
	maxAggShipQty:[''],
 
	preOrdLaunchDt:[''],
 
	preOrdEndDt:[''],
 
	preOrdQty:[''],
 
	preOrdRelDt:[''],
 
	isBackorder:[''],
 
	backOrderLimit:[''],
 
	shippingOptions:[""],
 
	dimensions:[""],
 
	variantsAttributes:[""],
 
	assetAttributes:[""],
 
	productAttributes:[""],
 
	discoveryAttributes:[""],
 
	othersAttributies:[""],
 
	legalAttributes:[""],
 
	isPreOrderAllow:[''],
 
	lowStockThreshold:[''],
	percentageType:[""]
    })
  }
httpHeaders:HttpHeaders=new HttpHeaders();

  ngOnInit(): void {
    this.httpHeaders = new HttpHeaders ({
      'Content-Type':'application/json',
      // 'Authorization':`Bearer ${localStorage.getItem('loginToken')}`
    })
  }
 
  onSubmit(){
    if(this.createForm.valid){
    this.http.post('http://localhost:8080/wms/product/api/saveProduct',this.createForm.value,{ headers:this.httpHeaders}).subscribe((res:any)=>{
      console.log("result",res);
     
    if(res!=null){
      console.log("Inside onSubmit");
      console.log("res->",res);
     
      this.createForm.patchValue(res);
      alert("saved Successfully");
      console.log("createForm.value",this.createForm.value);
      this.currentChildComponent=ProducthomeComponent;
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
    this.currentChildComponent=ProducthomeComponent;

    this.saveToggle=false;
   }

}
