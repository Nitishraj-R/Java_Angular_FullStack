import { AfterViewInit, ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProducthomeComponent } from '../producthome/producthome.component';
import { DataService } from '../../service/dataservice';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CommonService } from '../../service/common.service';
import { Router } from '@angular/router';
import { SupplierService } from '../../supplier/service/supplier.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-product-detail-page',
  templateUrl: './product-detail-page.component.html',
  styleUrls: ['./product-detail-page.component.css']
})
export class ProductDetailPageComponent implements OnInit{
    
  currentChildComponent: any = null;
  updateForm:FormGroup;
  httpHeaders:HttpHeaders=new HttpHeaders();

  theDate = new Date('2020/03/15');
  constructor(private http:HttpClient,private builder:FormBuilder,private commonService:CommonService,private router:Router,private supplierService:SupplierService,private cdr:ChangeDetectorRef,private datePipe: DatePipe){
    this.updateForm=this.builder.group({
      id:[""],
 
	skuNumber:[''],
 
	productId:[""],
 
	productidType:[""],
 
	productName:[""],
 
  productShortDesc:[""],
 
	parentSkuId:[""],
 
	status:[""],
 
	isReturnable:[""],
 
	maxOrdQty:[""],
 
	maxAggShipQty:[""],
 
	preOrdLaunchDt:new Date(),
 
	preOrdEndDt:[""],
 
	preOrdQty:[""],
 
	preOrdRelDt:[""],
 
	isBackorder:false,
 
	backOrderLimit:[""],
 
	shippingOptions:[""],
 
	dimensions:[""],
 
	variantsAttributes:[""],
 
	assetAttributes:[""],
 
	productAttributes:[""],
 
	discoveryAttributes:[""],
 
	othersAttributes:[""],
 
	legalAttributes:[""],
 
	isPreOrderAllow:[""],
 
	lowStockThreshold:[""],
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
    // this.data.preOrdRelDt="19-05-2024 11:15";
    console.log("this.updateForm.value",this.updateForm.value);
    
    this.updateForm.patchValue(this.data);
    // this.updateForm.value.preOrdLaunchDt=this.theDate;
    // this.updateForm.value.isBackorder=false;
    // this.updateForm.controls['isBackorder'].setValue(false);
    
    // this.updateForm.value.preOrdLaunchDt=new Date()
    // this.updateForm.controls['preOrdLaunchDt'].setValue("19-05-2024 11:15");
    console.log("this.updateForm.value",this.updateForm.value);
    console.log("this.updateForm.value.isBackorder",this.updateForm.value.isBackorder);
    
    this.cdr.detectChanges();
  })
  // this.commonService.commonmsg.subscribe(m=>{
  //   console.log("m->",m);
  //   // this.columns=m;
  // })
 
   
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
    // if(this.updateForm.valid){
    //   this.http.put(`http://localhost:8080/wms/product/api/updateProduct`,this.updateForm.value,{ headers:this.httpHeaders}).subscribe((res:any)=>{
    // if(res!=null){
    //   console.log("Inside formchange");
    //   console.log("res->",res);
      
    //   this.updateForm.patchValue(res);
    //   alert("Updated Successful");
    //   console.log("updateForm.value",this.updateForm.value);
    //   this.currentChildComponent=ProducthomeComponent;

 
    // }
    // })
    // }
    // else{
    //   console.log("Mandatory fields must be filled");
    //   alert("Mandatory fields must be filled");
      
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
      // this.updateForm.value.isBackorder=
      console.log("this.updateForm.value",this.updateForm.value);
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
    }
    else{
      console.log("Mandatory fields must be filled");
      alert("Mandatory fields must be filled");
      
    }
    
   
   }

   selectRadioButton(key:string,value:Boolean){
    switch(key){
      case "isBackorder":
        this.updateForm.value.isBackorder=value;
        console.log(this.updateForm.value.isBackorder);
        break;
      
      case 'isPreOrderAllow':
        this.updateForm.value.isPreOrderAllow=value;
        console.log(this.updateForm.value.isPreOrderAllow);
        break;
      case 'isReturnable':
        this.updateForm.value.isReturnable=value;
        console.log(this.updateForm.value.isReturnable);
        break;
    }
    
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