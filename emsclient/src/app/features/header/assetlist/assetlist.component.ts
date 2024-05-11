import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'assetlist',
  templateUrl: './assetlist.component.html',
  styleUrls: ['./assetlist.component.css']
})
export class AssetlistComponent {

  private getAllAssetsWithFixedAssetURL='http://localhost:8080/api/v1/asset';

  
  assetListResponse: any;

  @Output() searchResponse = new EventEmitter<any>();
  constructor(private http:HttpClient) {}
  onSearchClicked():void{
    this.http.get<any>(`${this.getAllAssetsWithFixedAssetURL}/allAssetWithFixedAssets`)
    .subscribe((data) =>{
      this.assetListResponse = data;
    this.searchResponse.emit(data);

    },(error) => {
      console.error('Error fetching asset data:', error);
    }
      
    );
    
  }

}
