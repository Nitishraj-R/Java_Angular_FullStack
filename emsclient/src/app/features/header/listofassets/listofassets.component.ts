import { Component, Input } from '@angular/core';

interface AssetDTO {
  serialNo: number;
  assetName: string;
  assetCode: string;
  description: string;
  modelNo: string;
  purchaseDate: string;
  assetStatus: string;
  cost: number;
  assignedStatus: string;
  assetType: string;
}
@Component({
  selector: 'listofassets',
  templateUrl: './listofassets.component.html',
  styleUrls: ['./listofassets.component.css']
})
export class ListofassetsComponent {
  @Input() responseDataAsList: any;

  assetDTO: any;

  getAssetDtoKeys(responseDataAsList: any): AssetDTO[] {
    if (responseDataAsList && responseDataAsList['assetDTO']) {
      return Object.keys(responseDataAsList['assetDTO']).map((key, index) => {
        const asset = responseDataAsList['assetDTO'][key];
        return {
          serialNo: index + 1,
          assetName: asset.assetName || 'N/A',
          assetCode: asset.assetCode || 'N/A',
          description: asset.description || 'N/A',
          modelNo: asset.modelNo || 'N/A',
          purchaseDate: asset.purchaseDate || 'N/A',
          assetStatus: asset.assetStatus || 'N/A',
          cost: asset.cost || 'N/A',
          assignedStatus: asset.assignedStatus || 'N/A',
          assetType: asset.assetType || 'N/A'
        };
      });
    }
    return [];
  }

}
