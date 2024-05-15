import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProducthomeComponent } from '../producthome/producthome.component';
import { DataService } from '../../service/dataservice';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonService } from '../../service/common.service';
import { Router } from '@angular/router';
import { SupplierService } from '../../supplier/service/supplier.service';

@Component({
  selector: 'app-product-detail-page',
  templateUrl: './product-detail-page.component.html',
  styleUrls: ['./product-detail-page.component.css']
})
export class ProductDetailPageComponent implements OnInit{
    
  currentChildComponent: any = null;
  updateForm:FormGroup;
  httpHeaders:HttpHeaders=new HttpHeaders();
  constructor(private http:HttpClient,private builder:FormBuilder,private commonService:CommonService,private router:Router,private supplierService:SupplierService){
    this.updateForm=this.builder.group({
      id:[""],
 
	skuNumber:[''],
 
	productId:[""],
 
	productidType:[""],
 
	productName:[""],
 
  productShortDesc:[""],
 
	parentSkuId:[Number],
 
	status:[Boolean],
 
	isReturnable:[Boolean],
 
	maxOrdQty:[Number],
 
	maxAggShipQty:[Number],
 
	preOrdLaunchDt:[Date],
 
	preOrdEndDt:[Date],
 
	preOrdQty:[Number],
 
	preOrdRelDt:[Date],
 
	isBackorder:[Boolean],
 
	backOrderLimit:[Number],
 
	shippingOptions:[""],
 
	dimensions:[""],
 
	variantsAttributes:[""],
 
	assetAttributes:[""],
 
	productAttributes:[""],
 
	discoveryAttributes:[""],
 
	othersAttributes:[""],
 
	legalAttributes:[""],
 
	isPreOrderAllow:[Boolean],
 
	lowStockThreshold:[Number],
	percentageType:[""]
    })
  }
  columns:string[]=["sd","sf"];
  data:any;
  update:boolean=true;
 
  employeeDetailsArray:[string, unknown][]=[];
  // employee=new Employee();
 
  // employeeDetailsArray = [];
  ngOnInit(): void {
    this.httpHeaders = new HttpHeaders ({
      'Content-Type':'application/json',
      // 'Authorization':`Bearer ${localStorage.getItem('loginToken')}`
    })
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
    
    this.http.delete(`http://localhost:8080/wms/product/api/deleteProduct?productId=${this.updateForm.value.productId}`,{ headers:this.httpHeaders}).subscribe((res:any)=>{
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
    this.currentChildComponent=ProducthomeComponent;

    // this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
    //   this.router.navigate([this.router.url]);
    // });
    })
    
   }

   formChange(){
    
    this.http.put(`http://localhost:8080/wms/product/api/updateProduct`,this.updateForm.value,{ headers:this.httpHeaders}).subscribe((res:any)=>{
    if(res!=null){
      console.log("Inside formchange");
      console.log("res->",res);
      
      this.updateForm.patchValue(res);
      alert("Updated Successful");
      console.log("updateForm.value",this.updateForm.value);
      this.currentChildComponent=ProducthomeComponent;

 
    }
    })

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
    
    console.log("this.updateForm.value",this.updateForm.value);
   
   }

   onCancel(){

    console.log("Inside onCancel");
    this.currentChildComponent=ProducthomeComponent;

   }

   onBack(){

    console.log("Inside onBack");
    this.currentChildComponent=ProducthomeComponent;

   }
  }