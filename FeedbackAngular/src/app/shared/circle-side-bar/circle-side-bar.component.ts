import { Component, OnInit } from '@angular/core';
import { CircleService } from 'src/app/circle/circle.service';
import { CircleModel } from 'src/app/circle/circle-response';

@Component({
  selector: 'app-circle-side-bar',
  templateUrl: './circle-side-bar.component.html',
  styleUrls: ['./circle-side-bar.component.css']
})
export class CircleSideBarComponent implements OnInit {
  circles: Array<CircleModel> = [];
  displayViewAll: boolean;

  constructor(private CircleService: CircleService) {
    this.CircleService.getAllCircles().subscribe(data => {
      if (data.length > 3) {
        this.circles = data.splice(0, 3);
        this.displayViewAll = true;
      } else {
        this.circles = data;
      }
    });
  }

  ngOnInit(): void { }

}