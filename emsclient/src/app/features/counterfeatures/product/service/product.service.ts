import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from 'src/app/features/model/product';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl=`${environment.baseUrl}`;
  httpHeaders:HttpHeaders=new HttpHeaders();

  constructor(private http:HttpClient) {
    this.httpHeaders=new HttpHeaders({
      'Content-Type':'application/json',
    })
   }


  search(searchValue:string){
    console.log("Inside Search method of Product service");
    return this.http.get<any[]>(`${this.baseUrl}/wms/product/api/search?search=${searchValue}`,{headers:this.httpHeaders});
    
  }
}
