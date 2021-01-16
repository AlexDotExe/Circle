import { Component, OnInit } from '@angular/core';
import { SubfeedModel } from '../subfeed-response';
import { SubfeedService } from '../subfeed.service';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-list-subfeeds',
  templateUrl: './list-subfeeds.component.html',
  styleUrls: ['./list-subfeeds.component.css']
})
export class ListSubfeedsComponent implements OnInit {

  subfeeds: Array<any>;
  constructor(private subfeedService: SubfeedService) { }

  ngOnInit() {
    this.subfeedService.getAllSubfeeds().subscribe(data => {
      this.subfeeds = data;
    }, error => {
      throwError(error);
    })
  }
}