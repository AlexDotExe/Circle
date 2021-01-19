import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CircleModel } from './Circle-Model';

@Injectable({
  providedIn: 'root'
})
export class CircleService {
  constructor(private http: HttpClient) { }

  getAllCircles(): Observable<Array<CircleModel>> {
    return this.http.get<Array<CircleModel>>('http://localhost:8080/api/circle/');
  }
  
  createCircle(circleModel: CircleModel): any {
    return this.http.post('http://localhost:8080/api/circle',
      circleModel);
  }
}