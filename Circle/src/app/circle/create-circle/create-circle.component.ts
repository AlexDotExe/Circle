import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CircleModel } from '../circle-response';
import { Router } from '@angular/router';
import { CircleService } from '../circle.service';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-create-circle',
  templateUrl: './create-circle.component.html',
  styleUrls: ['./create-circle.component.css']
})
export class CreateCircleComponent implements OnInit {
  createCircleForm: FormGroup;
  circleModel: CircleModel;
  title = new FormControl('');
  description = new FormControl('');

  constructor(private router: Router, private circleService: CircleService) {
    this.createCircleForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
    this.circleModel = {
      name: '',
      description: ''
    }
  }

  ngOnInit() {
  }

  discard() {
    this.router.navigateByUrl('/');
  }

  createCircle() {
    this.circleModel.name = this.createCircleForm.get('title')
    .value;
    this.circleModel.description = this.createCircleForm.get('description')
    .value;
    this.circleService.createCircle(this.circleModel).subscribe(data => {
      this.router.navigateByUrl('/list-circles');
    }, error => {
      throwError(error);
    })
  }
}