import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  constructor() { }
  isLoggedIn:Boolean=false;
  id:string|null='';

  private commonsubject=new BehaviorSubject('');
  public commonmsg=this.commonsubject.asObservable();

  private commonsubject2=new BehaviorSubject('');
  public commonmsg2=this.commonsubject2.asObservable();

  private commonsubject3=new BehaviorSubject('');
  public columnmsg3=this.commonsubject3.asObservable();

  sendObject(object:any){
    this.commonsubject.next(object);
  }

  sendColumn(column:any){
    this.commonsubject2.next(column);
  }

  getfullName(fullName:string){
    this.commonsubject3.next(fullName);
  }

  getIsLoggedIn(){
    return this.isLoggedIn;
  }
  setIsLoggeedIn(boolean:Boolean){
    this.isLoggedIn=boolean;
  }
  
  getId(){
    return  localStorage.getItem('id');
  }
  setId(object:string|null){
    this.id=object;
    console.log(this.id);
    
  }
}
