import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DataService } from '../../service/dataservice';

@Component({
  selector: 'app-producthome',
  templateUrl: './producthome.component.html',
  styleUrls: ['./producthome.component.css']
})
export class ProducthomeComponent implements OnInit{
  myForm: FormGroup;
 
  closeResult:any;
 
  formFields: any[] = [
    {Head:'SKU Number',FieldValue:'skuNumber'},
    {Head:'Product Id',FieldValue:'productId'},
    {Head:'Product Name',FieldValue:'productName'},
    {Head:'Description',FieldValue:'productShortDesc'},
    {Head:'Status',FieldValue:'status'},
    {Head:'Dimension',FieldValue:'dimensions'},
    ];
 
  constructor(private modalService: NgbModal,private http:HttpClient,private formBuilder: FormBuilder,private dataService: DataService){
    this.myForm = this.formBuilder.group({});
    this.formFields.forEach(field => {
      console.log("Field",field);
     
      this.myForm.addControl(field.FieldValue, new FormControl(''));
 
    });
  }
 
  productData: any[] = []; 
   
ngOnInit(){
  
  const url = 'http://localhost:8080/wms/product/api/getAllProducts';
 
    this.http.get<any[]>(url)
      .subscribe(data => {
        this.productData=data;
        // this.productData = data;  
        console.log("this.productData",this.productData);
        this.dataService.setSharedData(this.productData);
        
        console.log("data",data);
        
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
 
open(content:any) {
  this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
    this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}
 
private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
    return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
    return 'by clicking on a backdrop';
  } else {
    return `with: ${reason}`;
  }
}

setData() {
  console.log('setdata method');
  
 
}

}
