import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class SupplierService implements OnInit {

  constructor(private http:HttpClient) { }

  
  baseUrl=`${environment.baseUrl}`;
  httpHeaders:HttpHeaders=new HttpHeaders();

  ngOnInit(): void {
    this.httpHeaders = new HttpHeaders ({
      'Content-Type':'application/json',
      // 'Authorization':`Bearer ${localStorage.getItem('loginToken')}`
    })
  }

  postSupplier(supplier:any){
    console.log("inside postsupplier method of supplier service");
    
    return this.http.post(`${this.baseUrl}/wms/vendor/api/create`,supplier,{ headers:this.httpHeaders});
  }

  fetchAllSupplier(){
    console.log("inside fetchAllsupplier method of supplier service");
    
    return this.http.get(`${this.baseUrl}/wms/vendor/api/fetchAll`,{headers:this.httpHeaders});
  }

  deleteSupplier(vendorCode:string){
    console.log("inside deletesupplier method of supplier service");
    return this.http.delete<string>(`${this.baseUrl}/wms/vendor/api/delete?vendorCode=${vendorCode}`,{ headers:this.httpHeaders});
  }

  updateSupplier(supplier:any){
    console.log("inside updateSupplier method of supplier service");
    return this.http.put(`${this.baseUrl}/wms/vendor/api/update`,supplier,{ headers:this.httpHeaders});
  }

  fetchByVendorCode(vendorCode:string){
    console.log("inside fetchsupplierByVendorCode method of supplier service");
    return this.http.get(`${this.baseUrl}/wms/vendor/api/fetch/vendorCode=${vendorCode}`,{ headers:this.httpHeaders});
  }
}
