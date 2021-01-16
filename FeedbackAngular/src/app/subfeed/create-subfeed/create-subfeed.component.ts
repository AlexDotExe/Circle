import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SubfeedModel } from '../subfeed-response';
import { Router } from '@angular/router';
import { SubfeedService } from '../subfeed.service';

@Component({
  selector: 'app-create-subfeed',
  templateUrl: './create-subfeed.component.html',
  styleUrls: ['./create-subfeed.component.css']
})
export class CreateSubfeedComponent implements OnInit {
  createSubfeedForm: FormGroup;
  subfeedModel: SubfeedModel;
  title = new FormControl('');
  description = new FormControl('');
  error: string;

  constructor(private router: Router, private subfeedService: SubfeedService) {
    this.createSubfeedForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
    this.subfeedModel = {
      name: '',
      description: ''
    }
    this.error = '';
    
  }

  ngOnInit() {
  }

  discard() {
    this.router.navigateByUrl('/');
  }

  createSubfeed() {
    this.subfeedModel.name = this.createSubfeedForm.get('title').value;
    this.subfeedModel.description = this.createSubfeedForm.get('description').value;
    this.subfeedService.createSubfeed(this.subfeedModel).subscribe(data => {this.subfeedModel = data
      
    }, error => {
      console.log('Error occurred');
    })
    this.check();
  }

  check(){
    if(this.subfeedModel.name == '-1')
    this.error = 'Sorry this name is not allowed';
    else this.router.navigateByUrl('/list-subfeeds');

  }
}