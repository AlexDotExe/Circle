import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { CircleModel } from 'src/app/circle/circle-response';
import { Router } from '@angular/router';
import { PostService } from 'src/app/shared/post.service';
import { CircleService } from 'src/app/circle/circle.service';
import { CreatePostPayload } from './create-post.payload';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  createPostForm: FormGroup;
  postPayload: CreatePostPayload;
  circles: Array<any>;

  constructor(private router: Router, private postService: PostService,
    private circleService: CircleService) {
    this.postPayload = {
      postName: '',
      url: '',
      description: '',
      circleName: ''
    }
  }

  ngOnInit() {
    this.createPostForm = new FormGroup({
      postName: new FormControl('', Validators.required),
      circleName: new FormControl('', Validators.required),
      url: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
    this.circleService.getAllCircles().subscribe((data) => {
      this.circles = data;
    }, error => {
      throwError(error);
    });
  }

  createPost() {
    this.postPayload.postName = this.createPostForm.get('postName').value;
    this.postPayload.circleName = this.createPostForm.get('circleName').value;
    this.postPayload.url = this.createPostForm.get('url').value;
    this.postPayload.description = this.createPostForm.get('description').value;

    this.postService.createPost(this.postPayload).subscribe((data) => {
      this.router.navigateByUrl('/');
    }, error => {
      throwError(error);
    })
  }

  discardPost() {
    this.router.navigateByUrl('/');
  }

}