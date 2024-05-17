import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class CustomerService implements OnInit{

  constructor(private http:HttpClient) { }

  
  baseUrl=`${environment.baseUrl}`;
  httpHeaders:HttpHeaders=new HttpHeaders();

  ngOnInit(): void {
    this.httpHeaders = new HttpHeaders ({
      'Content-Type':'application/json',
      // 'Authorization':`Bearer ${localStorage.getItem('loginToken')}`
    })
  }

  postCustomer(customer:any){
    console.log("inside postCustomer method of Customer service");
    
    return this.http.post(`${this.baseUrl}/wms/customer/api/create`,customer,{headers:this.httpHeaders});
  }

  fetchAllCustomers(){
    console.log("inside fetchAllCustomers method of Customer service");
    
    return this.http.get(`${this.baseUrl}/wms/customer/api/fetchAll`,{headers:this.httpHeaders});
  }

  deleteCustomer(customerCode:string){
    console.log("inside deleteCustomer method of Customer service");
    return this.http.delete(`${this.baseUrl}/wms/customer/api/delete?customerCode=${customerCode}`,{headers:this.httpHeaders});
  }

  updateCustomer(customer:any){
    console.log("inside updateCustomer method of Customer service");
    return this.http.put(`${this.baseUrl}/wms/customer/api/update`,customer,{headers:this.httpHeaders});
    
  }

  fetchByCustomerCode(customerCode:string){
    console.log("inside fetchByCustomerCode method of Customer service");
    return this.http.get(`${this.baseUrl}/wms/customer/api/fetch/${customerCode}`,{headers:this.httpHeaders})
  }

  search(searchValue:string){
    console.log("Inside Search method of Customer service");
    return this.http.get<any[]>(`${this.baseUrl}/wms/customer/api/search?search=${searchValue}`,{headers:this.httpHeaders});
    
  }

}
