import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { TaskListComponent } from './task-list/task-list.component';
import { TaskDetailComponent } from './task-detail/task-detail.component';
import { TaskEditComponent } from './task-edit/task-edit.component';
import { SubtaskListComponent } from './subtask-list/subtask-list.component';

const routes: Routes = [
  { path: 'tasks', component: TaskListComponent },
  { path: 'detail/:id', component: TaskDetailComponent},
  { path: 'edit/:id', component: TaskEditComponent},
  { path: 'detail/:id/subtasks', component: SubtaskListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
