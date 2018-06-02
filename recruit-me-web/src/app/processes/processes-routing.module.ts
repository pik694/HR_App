import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProcessDetailsComponent} from './process-details/process-details.component';
import {ProcessFormComponent} from '../shared/process-form/process-form.component';

const routes: Routes = [
    {
        path: ':id',
        component: ProcessDetailsComponent,
    },
    {
        path: 'edit/:id',
        component: ProcessFormComponent,
    },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcessesRoutingModule {

}
