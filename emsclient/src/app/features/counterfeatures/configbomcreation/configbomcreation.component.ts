import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { WmsService } from '../service/wms.service';
import { ConfigbomlistviewComponent } from '../configbom/configbomlistview/configbomlistview.component';

@Component({
  selector: 'app-configbomcreation',
  templateUrl: './configbomcreation.component.html',
  styleUrls: ['./configbomcreation.component.css']
})
export class ConfigbomcreationComponent implements OnInit{
  state=true;
 
  // Define the form group
  studentForm: FormGroup;

  productArray: any[] = [];

  currentChildComponent: any = null;

  getState(){
   return this.state;
  }

  ngOnInit(): void {
    this.service.getAllProducts().subscribe((data:any)=>{
      console.log("The Products are ",data);
    
      data.forEach((element:any) => {
            this.productArray.push(element);
          });

    })

    console.log("The Product array values are ",this.productArray);
  
  }




  // Injecting FormBuilder service to help create the form group
  constructor(private fb: FormBuilder,private service:WmsService,private router:Router) {

    const codeGroup = this.fb.group({
      code: ['', Validators.required],
      productidType: ['', Validators.required],
      productName: ['', Validators.required],
      productShortDesc: ['', Validators.required],
      parentSkuId: ['', Validators.required],
      status: ['', Validators.required],
      lowStockThreshold: ['', Validators.required]
    });

    // Initializing the form group with FormArray for student list
    this.studentForm = this.fb.group({
      codeGroup: codeGroup,
      bomProductsList: this.fb.array([this.createStudentFields()])
    });
  }


  // Create a new form group for a student
  createStudentFields(): FormGroup {

    return this.fb.group({
      productMasterDto:['',Validators.required],
      qty: [0, [Validators.required, Validators.min(1)]], // Quantity is required and must be at least 1
      // Add other form controls here if needed (e.g. student_class, student_age)
    });
  }

  // Get the student list as a FormArray
  bomProductsListArray(): FormArray {
    return this.studentForm.get('bomProductsList') as FormArray;
  }

  // Function to add a new student form group to the student list
  addStudent(): void {
    this.bomProductsListArray().push(this.createStudentFields());
  }

  // Function to remove a student form group from the student list
  removeStudent(index: number): void {
    this.bomProductsListArray().removeAt(index);
  }

  // Function to handle form submission
  getFormData(): void {
    if (this.studentForm.valid) {
      // Form data to be sent to the server
      let firstCodeGroup=this.studentForm.get('codeGroup')?.value;
      console.log("The First Form value is ",firstCodeGroup);
    
      const bomProductsListArray = this.studentForm.get('bomProductsList')?.value;

      // Transform the BOM products list to include the productMaster as an object with the selected ID
      const bomProductsList = bomProductsListArray.map((item: { productMasterDto: any; qty: any; }) => ({
          productMasterDto:[ { id: item.productMasterDto }],
          qty: item.qty,
      }));

    

      
    

      // Construct the wholeObject with the codeGroup and bomProductsList
      let wholeObject = {
        ...this.studentForm.get('codeGroup')?.value,
        bomProductsList
      };

     console.log("Entire Object ",wholeObject);
    

      const formData = this.studentForm.value;
      console.log('Form data:', formData);

      console.log('whole object ',wholeObject);
      

      this.service.postBomConfig(wholeObject).subscribe((data:any)=>{
        console.log("The Data received ",data);
        this.state=false;
        this.currentChildComponent=ConfigbomlistviewComponent
        })

      // Implement any additional logic here, such as sending the form data to the server
      // using an HTTP client service (e.g., HttpClient).
    } else {
      // Handle form validation errors if needed
      console.log('Form is invalid');
    }
  }
}