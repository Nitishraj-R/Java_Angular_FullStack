import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-tablerender',
  templateUrl: './tablerender.component.html',
  styleUrls: ['./tablerender.component.css']
})
export class TablerenderComponent {
  
  @Input() data: any[] = [];
  @Input() columns: any[] = [];
  @Output () onEdit = new EventEmitter<any>();
  @Output () onDelete = new EventEmitter<any>();

  edit(item: any) {
    console.log("Table edit");
   
    this.onEdit.emit(item);
  }
  deleteRecord(item: any) {
    console.log("Table delete");
    this.onDelete.emit(item);
  }
 

}
