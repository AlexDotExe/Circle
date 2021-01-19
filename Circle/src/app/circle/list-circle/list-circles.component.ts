import { Component, OnInit } from '@angular/core';
import { CircleService } from '../circle.service';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-list-circles',
  templateUrl: './list-circles.component.html',
  styleUrls: ['./list-circles.component.css']
})
export class ListCirclesComponent implements OnInit {

  circles: Array<any>;
  constructor(private circleService: CircleService) { }

  ngOnInit() {
    this.circleService.getAllCircles().subscribe(data => {
      this.circles = data;
    }, error => {
      throwError(error);
    })
  }
}