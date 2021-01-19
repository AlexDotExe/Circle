import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/shared/post.service';
import { ActivatedRoute } from '@angular/router';
import { CommentService } from 'src/app/comment/comment.service';
import { PostModel } from 'src/app/shared/post-model';
import { CommentPayload } from 'src/app/comment/comment.payload';


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  name: string;
  posts: PostModel[];
  comments: CommentPayload[];
  postLength: number;
  commentLength: number;
  comStyle:any;
  com:boolean;
  pos:boolean;
  postStyle:any;

  constructor(private activatedRoute: ActivatedRoute, private postService: PostService,
    private commentService: CommentService) {
    this.comStyle = {'display': 'none'};
    this.postStyle = {'display': 'none'};
    this.com =true;
    this.pos =true;
    this.name = this.activatedRoute.snapshot.params.name;

    this.postService.getAllPostsByUser(this.name).subscribe(data => {
      this.posts = data;
      this.postLength = data.length;
    });
    this.commentService.getAllCommentsByUser(this.name).subscribe(data => {
      this.comments = data;
      this.commentLength = data.length;
    });
  }

  ngOnInit(): void {
  }
showComment(){
  if(this.com)this.comStyle = {'display': 'block'};
  else this.comStyle = {'display' : 'none'};
  this.com =!this.com;
}
showPost(){
  if(this.pos)this.postStyle= {'display': 'block'};
  else this.postStyle = {'display' : 'none'};
  this.pos=!this.pos;
}

}