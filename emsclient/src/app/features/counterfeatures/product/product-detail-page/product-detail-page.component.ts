import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ProducthomeComponent } from '../producthome/producthome.component';
import { DataService } from '../../service/dataservice';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-detail-page',
  templateUrl: './product-detail-page.component.html',
  styleUrls: ['./product-detail-page.component.css']
})
export class ProductDetailPageComponent implements OnInit,AfterViewInit{
    rowData:any;
    @ViewChild('rowDiv') rowDiv!:ElementRef;
   
    currentChildComponent: any = null;

    edit:Boolean=true;

    editForm1:FormGroup;
   
    constructor(private dataService:DataService,private http:HttpClient,
                private formBuilder:FormBuilder){
                  this.editForm1=this.formBuilder.group({
                    id:[''],
                    skuNumber:[''],
                    productId:['',Validators.required],
                    productName:[''],
                    productShortDesc:[''],
                    manufacturer:[''],
                    category:[''],
                    subcategory:[''],
                    material:[''],
                    color:[''],
                    compatibilityNotes:[''],
                    warranty:[''],
                    dimensions:[''],
                    status:true,
                    vendor:[],
                    maxOrdQty:[''],
                    isPreOrderAllow:[''],
                    preOrdQty:[''],
                    preOrdRelDt:[''],
                    preOrdEndDt:[''],
                    maxAggShipQty:['']
            
            
                  })
                 
                }
  ngOnInit(): void {
   
      this.rowData=this.dataService.getRowData();
      console.log("rowDataDetailComponent",this.rowData);
      this.editForm1.patchValue(this.rowData);
      console.log("EditForm",this.editForm1);

     
  }
   
  ngAfterViewInit(): void {
      console.log("ngAfterViewInit method is called");
   
      // console.log(this.rowDiv.nativeElement.value.productId);
     
     
     
  }
   
  deleteRecord(){
    console.log("inside Delete Method");
   
    let id=this.rowData.productId;
    console.log("ID",id);
    console.log('http://localhost:8080/wms/product/api/deleteProduct?productId='+id);
   
   
     this.http.delete('http://localhost:8080/wms/product/api/deleteProduct?productId='+id).subscribe(res=>{
      console.log(res);
     });
     this.currentChildComponent=ProducthomeComponent;
   
  }

  editRecord(){
    this.edit=false;
    console.log(this.rowData);
    
  }
  onSubmit(){
    console.log("Inside save");
    this.http.put('http://localhost:8080/wms/product/api/updateProduct',this.editForm1.value).subscribe(res=>{
      console.log(res);
      this.currentChildComponent=ProducthomeComponent;
      // this.route.navigateByUrl('/features')
      
    })
    
    
  }
  
   
   
   
  }