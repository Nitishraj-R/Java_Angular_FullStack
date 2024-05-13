import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
 
  userData: any;
  formFields:any[]=[];
  rowData:any;

 constructor() { }

 setSharedData(userData: any) {
   console.log('userdata from product',userData);
  
   this.userData =[... userData];
   console.log('inside setshareddata');
   console.log("userdata",this.userData);
   // console.log('method shared data ',this.getSharedData());
    
  
  
 }
 getSharedData(){
   return this.userData;
 }

 setFieldColumns(formFields:any){
   this.formFields=[...formFields];
 }

 getFieldColums(){
   return this.formFields;
 }


 setRowData(rowData:any){
   this.rowData=rowData;
 }

 getRowData(){
   return this.rowData;
 }
}