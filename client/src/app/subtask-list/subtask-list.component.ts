import { Component, OnInit } from '@angular/core';
import { TaskService } from '../shared/task/task.service';
import { Task } from '../task';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common'

@Component({
  selector: 'app-subtask-list',
  templateUrl: './subtask-list.component.html',
  styleUrls: ['./subtask-list.component.css'],
  providers: [TaskService]
})
export class SubtaskListComponent implements OnInit {
  tasks: Array<any>;
  selectedTask : Task;

  constructor(private taskService: TaskService,
    private route: ActivatedRoute,
    private location: Location) { }

  ngOnInit() {
    this.getTasks();
  }

  getTasks(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.taskService.getSubtasks(id).subscribe(tasks => this.tasks = tasks);
  }

  onSelect(task: Task): void {
    this.selectedTask = task;
  }

  goBack(): void {
    this.location.back();
  }
}
