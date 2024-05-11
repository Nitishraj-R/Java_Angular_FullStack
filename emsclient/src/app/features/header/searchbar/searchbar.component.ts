import { Component, EventEmitter, Input, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent {
  // selectedCategory: string = ''; // Initialize selectedCategory to 'asset'
  selectedCategory: string | undefined;
  asset: string = ''; // Define asset property
  employeeName: string = ''; // Define employee property
  assetCode: string = ''; // Initialize assetCode

  assetDataResponse: any;

  @Output() searchResponse = new EventEmitter<any>();
  @Output() selectedCategoryChange = new EventEmitter<string>();

  private getAssetByCodeURL='http://localhost:8080/api/v1/asset';
  private getAssetByEmpoyeeNameURL='http://localhost:8080/api/employee';


  constructor(private http:HttpClient) {}

  
  onCategoryChange(): void {
    this.selectedCategoryChange.emit(this.selectedCategory);
  }

  onSearchClicked(assetCode: string,employeeName: string): void {
    if (this.selectedCategory === 'asset') {
       this.http.get<any>(`${this.getAssetByCodeURL}/assetsbycode?assetCode=${assetCode}`).subscribe(
        (data) => {
          this.assetDataResponse = data;
          console.log('searched by asset code',this.assetDataResponse);
          this.searchResponse.emit(data);
          
        },
        (error) => {
          console.error('Error fetching asset data:', error);
        }
      );
    }
    else if (this.selectedCategory === 'employee') {
      // http://localhost:8080/api/employee/assets?username=rahul
      this.http.get<any>(`${this.getAssetByEmpoyeeNameURL}/assets?username=${employeeName}`).subscribe(
       (data) => {
         this.assetDataResponse = data;
         console.log('searched by employee name',this.assetDataResponse);
         this.searchResponse.emit(data);
     
       },
       (error) => {
         console.error('Error fetching asset data:', error);
       }
     );
   }
  }


  // onCategoryChange(): void {
  //   if (this.selectedCategory === 'asset') {
  //     this.searchService.searchByAsset(this.assetCode);
  //   } else {
  //     this.searchService.search(this.searchTerm, this.selectedCategory);
  //   }
  // }

}
