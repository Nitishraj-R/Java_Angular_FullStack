export class Supplier {
    id:number=0;
    vendorName:string="";
    registrationNo:string="";

	status:boolean=true;

	address:string="";

	phoneNumber:string="";

	emailAddress:string="";

	shippingCost:number=0;

	tax:string="";
	
	vendorCode:string="";

	paymentTerm:string="";

	createdBy:string="";

	createdDate:Date=new Date();

	modifiedBy:string="";

	lastmodifiedDate:Date=new Date();

	rmaPolicy:number=0;
	
	adminEmailId:string="";
	
	primaryContactNumber:string="";
	
	secondaryContactNumber:string="";

}
