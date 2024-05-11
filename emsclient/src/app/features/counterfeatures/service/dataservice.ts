import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
 
   userData: any;

  constructor() { }

  setSharedData(userData: any) {
    console.log('userdata from product',userData);
    
    this.userData = userData;
    console.log('inside setshareddata');
    console.log("userdata",this.userData);
    console.log('method shared data ',this.getSharedData());
      
    
    
  }

  getSharedData(){
    return this.userData;
  }
}