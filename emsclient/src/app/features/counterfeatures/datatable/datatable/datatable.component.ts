import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { DatatableDataSource } from './datatable-datasource';
import { DataService } from '../../service/dataservice';

@Component({
  selector: 'app-datatable',
  templateUrl: './datatable.component.html',
  styleUrls: ['./datatable.component.css']
})
export class DatatableComponent implements AfterViewInit{
 
  @Input() columns: any[] = [];

  constructor(private dataService:DataService){}

  ngOnInit(): void {
    console.log("columns []",this.columns);
    for (let index = 0; index < this.columns.length; index++) {
      this.displayedColumns.push(this.columns[index].FieldValue);
      
    }
    console.log('displayedColumns',this.getDisplayedColumns());
  }
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<any>;
  dataSource = new DatatableDataSource(this.dataService);


  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns:any []= this.columns;

  getDisplayedColumns(){
    return this.displayedColumns;
  }

    ngAfterViewInit(): void {
    console.log("Datasource",this.dataSource);
    
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.dataSource.columns=this.displayedColumns;
    // this.dataSource.data=this.dataService.userData;
    this.table.dataSource = this.dataSource;
  }
}
