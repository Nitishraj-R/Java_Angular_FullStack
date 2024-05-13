import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataService } from '../../service/dataservice';
import { Router } from '@angular/router';
import { CreateProductComponent } from '../create-product/create-product.component';

@Component({
  selector: 'app-producthome',
  templateUrl: './producthome.component.html',
  styleUrls: ['./producthome.component.css']
})
export class ProducthomeComponent implements OnInit{
  myForm: FormGroup;
  url = 'http://localhost:8080/wms/product/api/getAllProducts';
 
  closeResult:any;
  currentChildComponent: any = null;
 
  formFields: any[] = [
    {Head:'SKU Number',FieldValue:'skuNumber'},
    {Head:'Product Id',FieldValue:'productId'},
    {Head:'Product Name',FieldValue:'productName'},
    {Head:'Description',FieldValue:'productShortDesc'},
    {Head:'Status',FieldValue:'status'},
    {Head:'Dimension',FieldValue:'dimensions'},
    ];
 
  constructor(private modalService: NgbModal,
              private http:HttpClient,
              private formBuilder: FormBuilder,
              private dataService: DataService,
            private router:Router){
    this.myForm = this.formBuilder.group({});
    this.formFields.forEach(field => {
      console.log("Field",field);
     
      this.myForm.addControl(field.FieldValue, new FormControl(''));
 
      this.http.get<any[]>(this.url)
      .subscribe(data => {
        if(data){
          this.productData=data;
          console.log("productData->",this.productData);
          
      this.dataService.setSharedData(data);
        }
    })
    });
  }
 datatableDisplay:boolean=false;
  productData: any[] = [];
  keys:any[]=[];
   
ngOnInit(){
 
  
  console.log("url of all product is",this.url);
 
    this.http.get<any[]>(this.url)
      .subscribe(data => {
        if(data){
          this.productData=data;
          // this.productData = data;  
          console.log("this.productData",this.productData);
          this.keys=Object.keys(this.productData[0]);
          console.log("key",Object.keys(this.productData[0]));
           const dataKey=Object.keys(data[0]);
           
           
          const keyWithValue= data.filter(key=>data[key as keyof typeof data]!==null );
          console.log("keyWithValue",keyWithValue);
         
         
          console.log("this.key",this.keys);
         
         
          this.dataService.setSharedData(this.productData);
          this.dataService.setFieldColumns(this.formFields);
          this.datatableDisplay=true;
          console.log("data",data);
        }
        else{
          console.log("data",data);
         
        }
       
       
      });
     
     
  }
  
 
 
editProduct(item:any){
console.log("Inside edit");
console.log("item",item);
 
 
}
 
deleteProduct(item:any){
  console.log("Inside delete");
 
}
 
save(){
  console.log("inside save");
  console.log(this.myForm.value);
 
 
}
 

 
setData() {
  console.log('setdata method');
 
 
}
}
