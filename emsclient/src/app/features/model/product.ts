export class Product {
    id:string="";
 
	skuNumber:string='';
 
	productId:string="";
 
	productidType:string="";
 
	productName:string="";
 
  productShortDesc:string="";
 
	parentSkuId:Number=0;
 
	status:Boolean=true;
 
	isReturnable:Boolean=true;
 
	maxOrdQty:Number=0;
 
	maxAggShipQty:Number=0;
 
	preOrdLaunchDt:Date=new Date();
 
	preOrdEndDt:Date=new Date();
 
	preOrdQty:Number=0;
 
	preOrdRelDt:Date=new Date();
 
	isBackorder:Boolean=true;
 
	backOrderLimit:Number=0;
 
	shippingOptions:string="";
 
	dimensions:string="";
 
	variantsAttributes:string="";
 
	assetAttributes:string="";
 
	productAttributes:string="";
 
	discoveryAttributes:string="";
 
	othersAttributies:string="";
 
	legalAttributes:string="";
 
	isPreOrderAllow:Boolean=true;
 
	lowStockThreshold:Number=0;
	percentageType:string="";
}
