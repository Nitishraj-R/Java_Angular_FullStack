export class Product {
    id:string="";
 
	skuNumber:string='';
 
	productId:string="";
 
	productidType:string="";
 
	productName:string="";
 
  productShortDesc:string="";
 
	parentSkuId:Number | null=null;
 
	status:Boolean | null=null;
 
	isReturnable:Boolean | null=null;
 
	maxOrdQty:Number | null=null;
 
	maxAggShipQty:Number | null=null;
	preOrdLaunchDt:Date | null=null;
 
	preOrdEndDt:Date | null=null;
 
	preOrdQty:Number | null=null;
 
	preOrdRelDt:Date | null=null;
 
	isBackorder:Boolean=true;
 
	backOrderLimit:Number | null=null;
 
	shippingOptions:string="";
 
	dimensions:string="";
 
	variantsAttributes:string="";
 
	assetAttributes:string="";
 
	productAttributes:string="";
 
	discoveryAttributes:string="";
 
	othersAttributies:string="";
 
	legalAttributes:string="";
 
	isPreOrderAllow:Boolean | null=null;
 
	lowStockThreshold:Number | null=null;
	percentageType:string="";
}
