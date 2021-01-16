import { Component, OnInit } from '@angular/core';
import { SubfeedService } from 'src/app/subfeed/subfeed.service';
import { SubfeedModel } from 'src/app/subfeed/subfeed-response';

@Component({
  selector: 'app-subfeed-side-bar',
  templateUrl: './subfeed-side-bar.component.html',
  styleUrls: ['./subfeed-side-bar.component.css']
})
export class SubfeedSideBarComponent implements OnInit {
  subfeeds: Array<SubfeedModel> = [];
  displayViewAll: boolean;

  constructor(private SubfeedService: SubfeedService) {
    this.SubfeedService.getAllSubfeeds().subscribe(data => {
      if (data.length > 3) {
        this.subfeeds = data.splice(0, 3);
        this.displayViewAll = true;
      } else {
        this.subfeeds = data;
      }
    });
  }

  ngOnInit(): void { }

}