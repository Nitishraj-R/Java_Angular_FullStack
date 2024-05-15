import { Component, OnInit } from '@angular/core';
import { WmsService } from '../../service/wms.service';

import { Router } from '@angular/router';
import { ConfigbomcreationComponent } from '../../configbomcreation/configbomcreation.component';
 
@Component({
  selector: 'app-configbomlistview',
  templateUrl: './configbomlistview.component.html',
  styleUrls: ['./configbomlistview.component.css']
})
export class ConfigbomlistviewComponent  implements OnInit{
 
  listConfigData:any[]=[];
 
  currentChildComponent: any = null;
 
  state=true;
 
 
 
  constructor(private service:WmsService,private router:Router){}
 
  ngOnInit(): void {
 
    this.service.getAllConfigBom().subscribe((data:any)=>{
      console.log("The Config List data ",data);
     
      data.forEach((Element: any) => {
        this.listConfigData.push(Element);
      });
   
      console.log("At first Index ",this.listConfigData.at(0));
 
      console.log("At first Index ",this.listConfigData.at(1));
     
    });
 
 
  }
 
  createNewBom(){
    // this.router.navigate(['/configbom']);
 
    this.currentChildComponent=ConfigbomcreationComponent;
 
    this.state=false;
  }
 
 getState(){
  return this.state;
 }
 
 
}