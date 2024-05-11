import { Component } from '@angular/core';
import { UserProfileService } from '../service/userprofileservice';

@Component({
  selector: 'userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent {
  userData: any;

  constructor(private userService: UserProfileService) { }
  
  ngOnInit(): void {
    // Get user data from the service
    this.userData = this.userService.getUserData();
  }

}
