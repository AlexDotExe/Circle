import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './signup/signup.component';
import {LoginComponent} from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UserProfileComponent } from './user-profile/user-profile.component';
import{PostTileComponent} from '../shared/post-tile/post-tile.component';
@NgModule({
  declarations: [
    SignupComponent,
    LoginComponent,
    UserProfileComponent,
    PostTileComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class AuthModule { }