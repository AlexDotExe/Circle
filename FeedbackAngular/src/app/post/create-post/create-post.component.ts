import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { SubfeedModel } from 'src/app/subfeed/subfeed-response';
import { Router } from '@angular/router';
import { PostService } from 'src/app/shared/post.service';
import { SubfeedService } from 'src/app/subfeed/subfeed.service';
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
  subfeeds: Array<any>;

  constructor(private router: Router, private postService: PostService,
    private subfeedService: SubfeedService) {
    this.postPayload = {
      postName: '',
      url: '',
      description: '',
      subfeedName: ''
    }
  }

  ngOnInit() {
    this.createPostForm = new FormGroup({
      postName: new FormControl('', Validators.required),
      subfeedName: new FormControl('', Validators.required),
      url: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
    this.subfeedService.getAllSubfeeds().subscribe((data) => {
      this.subfeeds = data;
    }, error => {
      throwError(error);
    });
  }

  createPost() {
    this.postPayload.postName = this.createPostForm.get('postName').value;
    this.postPayload.subfeedName = this.createPostForm.get('subfeedName').value;
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