import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class WmsService {

  baseUrl=`${environment.baseUrl}`;
 
  constructor(private http:HttpClient) { }
 
  postBomConfig(configData:any){
   return  this.http.post(`${this.baseUrl}/wms/bomproduct/api/create`,configData)
  }
 
  getAllProducts(){
    return this.http.get(`${this.baseUrl}/wms/product/api/getAllProducts`);
  }
}
