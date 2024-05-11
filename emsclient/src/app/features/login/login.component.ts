import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonService } from '../counterfeatures/service/common.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  
  myForm:FormGroup;
  

  
  constructor(private http:HttpClient,private formBuilder:FormBuilder,private router:Router,private commonService:CommonService){
    this.myForm=this.formBuilder.group({
    "emailId":['',Validators.required],
    "password":['',Validators.required]
});

  }

onSubmit()
{
  console.log("inside Login");
  // this.http.post('http://localhost:8080/wms/customer/api/authenticate',this.myForm.value).subscribe((res:any)=>{
  // this.commonService.setIsLoggeedIn(true);
  // console.log("Token in login",res.data.token);
  // let token = res.data.token;
  // localStorage.setItem('loginToken',token);
  // let cus=res.data.customerDto.customerCode;
  // localStorage.setItem('id',cus);
  // this.commonService.setId(localStorage.getItem('id'));
  // var name=res.data.customerDto.customerName;
  // // var lastName=res.data.customerDto.lastName;
  // // var fullName=firstName+" "+lastName;
  //  localStorage.setItem('fullName',name);
  // // console.log(firstName+" "+lastName);
  // this.commonService.getfullName(name);
    
  //   if(token!=null){
   
  //    console.log(res.result);
  //   //  var token= res.headers.get('Authorization');
  //     // localStorage.setItem('loginToken',res.data.token);
  //     console.log("Token:"+token);
  //     this.router.navigate(['/features']);
  //   }else{
  //     alert('login Failed')
  //   }
  // })

  this.router.navigate(['/features']);
  
}
}
