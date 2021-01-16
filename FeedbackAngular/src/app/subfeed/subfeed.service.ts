import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SubfeedModel } from './Subfeed-Model';

@Injectable({
  providedIn: 'root'
})
export class SubfeedService {
  constructor(private http: HttpClient) { }

  getAllSubfeeds(): Observable<Array<SubfeedModel>> {
    return this.http.get<Array<SubfeedModel>>('http://localhost:8080/api/subfeed/');
  }
  createSubfeed(subfeedModel: SubfeedModel): any {
    return this.http.post('http://localhost:8080/api/subfeed',
      subfeedModel);
  }
}