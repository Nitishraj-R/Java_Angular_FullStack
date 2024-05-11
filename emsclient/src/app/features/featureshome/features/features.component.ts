import { Component, OnInit, Type, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ListofassetsComponent } from '../../header/listofassets/listofassets.component';
import { Observable, map, shareReplay } from 'rxjs';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { CreatecustomerComponent } from '../../counterfeatures/customer/createcustomer/createcustomer.component';
import { TablerenderComponent } from '../../counterfeatures/customer/tablerender/tablerender.component';
import { ProducthomeComponent } from '../../counterfeatures/product/producthome/producthome.component';
import { SupplierhomeComponent } from '../../counterfeatures/supplier/supplierhome/supplierhome.component';
import { DashboardComponent } from '../../counterfeatures/dashboard/dashboard.component';
import { ConfigbomComponent } from '../../counterfeatures/configbom/configbom.component';
import { CustomerhomeComponent } from '../../counterfeatures/customer/customerhome/customerhome.component';

@Component({
  selector: 'features',
  templateUrl: './features.component.html',
  styleUrls: ['./features.component.css']
})
export class FeaturesComponent implements OnInit {

  loading:boolean=true;

 currentChildComponent: any = DashboardComponent;



  constructor(private activatedRoute: ActivatedRoute,private router:Router){}

  ngOnInit(): void {
    // this.navigateToChild('child1');

    setTimeout(() => {
      console.log("inside setTimeOut() in navigation component for loading");
      
      this.loading=false;
      
    }, 2800);
  }

  



  navigateToChild(child: string) {
    console.log('navigate to child c');
    
    switch (child) {
      case 'child1':
        this.currentChildComponent = DashboardComponent;
        console.log('inside child 1');
        console.log('currentchildcomponent',this.currentChildComponent);
        
        break;

      case 'child2':
        this.currentChildComponent=CustomerhomeComponent;
        console.log('inside child 2');
        console.log('currentchildcomponent',this.currentChildComponent);
       
        break;

      case 'child3':
        this.currentChildComponent=ProducthomeComponent;
        console.log('inside child 3');
        console.log('currentchildcomponent',this.currentChildComponent);
       
        break;
      case 'child4':
        this.currentChildComponent = ConfigbomComponent;
        console.log('inside child 4');
        console.log('currentchildcomponent',this.currentChildComponent);
        
        break;
      case 'child5':
        this.currentChildComponent = SupplierhomeComponent;
        console.log('inside child 4');
        console.log('currentchildcomponent',this.currentChildComponent);
        
        break;
    }
  }

  selectedItem: string | null = null;


  selectItem(item: string) {
    this.selectedItem = item;
  }






logout():void{
  const token = localStorage.getItem('token');
  console.log('inside logout method');
  
  console.log(token);
  
  if (!token) {
    console.log('Token already removed.');
  } else {

    if(confirm('Are you sure you want to logout?')){
      localStorage.removeItem('token');
      this.router.navigate(['/homepage']); 
      console.log('Token removed successfully.');
    }else 
    console.log('Logout cancelled.');
    
  }
}



selectedCategory: string = '';

onSelectedCategoryChange(category: string): void {
  this.selectedCategory = category;
  console.log('selected category from features ',this.selectedCategory);
  
}
}
