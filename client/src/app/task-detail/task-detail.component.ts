import { Component, OnInit, NgModule, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { FormsModule } from '@angular/forms'

import { Task } from '../task';
import { TaskService } from '../shared/task/task.service';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {
  task: Task;

  constructor(private route: ActivatedRoute,
    private taskService: TaskService,
    private location: Location) { }

  ngOnInit(): void {
    this.getTask();
  }
  
  getTask(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.taskService.getTask(id).subscribe(task => this.task = task);
  }

  goBack(): void {
    this.location.back();
  }

}
