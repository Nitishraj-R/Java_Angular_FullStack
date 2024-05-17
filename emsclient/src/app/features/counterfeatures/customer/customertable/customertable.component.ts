import { Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { CommonService } from '../../service/common.service';
import { Router } from '@angular/router';
import { CreatecustomerComponent } from '../createcustomer/createcustomer.component';
import { CustomerDetailPageComponent } from '../customer-detail-page/customer-detail-page.component';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-customertable',
  templateUrl: './customertable.component.html',
  styleUrls: ['./customertable.component.css']
})
export class CustomertableComponent {
  @Input() data:any[]=[];
  @Input() columnss:string[]=[];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  currentChildComponent: any = null;

  editable=false;
  editCache: { [key: number]: {data:any,edit:any} } = {};
  editData:any;
  searchValue:string="";

  constructor(private commonService:CommonService,private router:Router,private customerService:CustomerService){}
  
  ngAfterViewInit(): void {
    // this.dataSource.sort = this.sort;
    // this.dataSource.paginator = this.paginator;
    // this.table.dataSource = this.dataSource;
    // console.log("this.dataSource.sort",this.dataSource.sort);
    // console.log("this.dataSource.paginator",this.dataSource.paginator);
    // console.log("this.table.dataSource",this.table.dataSource);
    this.getPagedData(this.getSortedData([...this.data]));
  }

  ngOnInit(): void {
    // this.editCache[1]=true;
    for (let index = 0; index < this.data.length; index++) {
      console.log(this.data[index]);
      console.log(this.data[index].id);
      this.editCache[this.data[index].id]={
        data : {...this.data[index]},
        edit : false
      }
      
      
      
    }
    console.log("editCache",this.editCache);
    
    // console.log("this.editCache[item.id].edit",this.editCache[0].edit);
    // console.log("this.editCache[item.id].data",this.editCache[0].data);
    
  }

  createNewDetails(){
    console.log("inside createNewDetails method");
    // this.router.navigate(['/features/createSupplier']);
    this.currentChildComponent=CreatecustomerComponent;

    
  }


  edit(item:any){
    console.log("edit is clicked ->",item);
    this.editable=true;
    this.editCache[item.id].edit=true;
    this.editData=item;
    console.log("this.editCache[item.id].data",this.editCache[item.id].data);
    console.log("this.editCache[item.id].data",this.editCache[item.id].data.id);
  }

  search(){
    console.log("Inside search button");
    console.log("searchValue is",this.searchValue);
    this.customerService.search(this.searchValue).subscribe((res:any[])=>{
      if(res){

        console.log("res->",res);
        this.data=res;
      }
      else{
        alert("No Record is found")
        console.log("No Record is found");
      }
     
      
    })
    
  }

  private getPagedData(data: any[]): any[] {
    if (this.paginator) {
      const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
      return data.splice(startIndex, this.paginator.pageSize);
    } else {
      return data;
    }
  }

  private getSortedData(data: any[]):any[] {
    if (!this.sort || !this.sort.active || this.sort.direction === '') {
      return data;
    }
    return data.sort((a, b) => {
      const isAsc = this.sort?.direction === 'asc';
      switch (this.sort?.active) {
        case 'firstName': return compare(a.vendorName, b.vendorName, isAsc);
        case 'id': return compare(+a.id, +b.id, isAsc);
        default: return 0;
      }
    });
  }

  

  detailspage(item : any){
    console.log("item in detailspage",item);
    this.commonService.sendObject(item);
    // this.commonService.sendColumn(this.columnss);
    // this.router.navigate(['/features/detailPage']);
    this.currentChildComponent=CustomerDetailPageComponent;

  }
  
}

function compare(a: string | number, b: string | number, isAsc: boolean): number {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}