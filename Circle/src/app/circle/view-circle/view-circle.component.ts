import { Component, OnInit } from '@angular/core';
import { PostModel } from 'src/app/shared/post-model';
import{ PostService } from '../../shared/post.service';
import{ ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-circle',
  templateUrl: './view-circle.component.html',
  styleUrls: ['./view-circle.component.css']
})
export class ViewCircleComponent implements OnInit {

posts:Array<PostModel>;
id:number;
circleName:string;

  constructor(private ps: PostService, private route: ActivatedRoute, private router: Router ) {
  }

  ngOnInit(): void {
    this.id = +this.route.snapshot.url[1].path;
    this.ps.getAllPostsByCircle(this.id).subscribe(post =>{this.posts = post});
  }
 getName(){
   if(this.posts != null && this.posts[0].circleName !== null)return this.posts[0].circleName;
   else return 'No Posts Yet';
 }

 goToPost(id){
this.router.navigateByUrl('view-post/'+id);
 }
}
