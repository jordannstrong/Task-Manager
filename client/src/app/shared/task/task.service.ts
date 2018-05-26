import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Task } from '../../task'

@Injectable()
export class TaskService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/test-tasks');
  }

  getSubtasks(id: number): Observable<any> {
    return this.http.get('http://localhost:8080/get-children/' + id);
  }

  getTask(id: number): Observable<any> {
    return this.http.get('http://localhost:8080/' + id);
  }

  updateTask(task: Task): Observable<any> {
    const url = 'http://localhost:8080/update/';
    const body = JSON.stringify(task);
    const headers = new HttpHeaders(
      {
      'Content-Type': 'application/json'
      });
    const options = ({headers: headers});
    return this.http.put(url, body, options);
  }

}
