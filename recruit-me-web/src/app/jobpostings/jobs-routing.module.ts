import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {JobPostingsFormComponent} from './jobpostings-form/jobpostings-form.component';
import {JobPostingsDetailsComponent} from './jobpostings-details/jobpostings-details.component';
import {JobPostingsListComponent} from './jobpostings-list/jobpostings-list.component';
import {ProcessFormComponent} from '../shared/process-form/process-form.component';

const routes: Routes = [
    {
        path: ':jobid/processes/create',
        component: ProcessFormComponent,
    },
    {
        path: 'edit/:id',
        component: JobPostingsFormComponent,
    },
    {
        path: 'create',
        component: JobPostingsFormComponent,
    },
    {
        path: ':id',
        component: JobPostingsDetailsComponent,
    },
    {
        path: '',
        component: JobPostingsListComponent,
    }
];

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild(routes)
    ],
    exports: [RouterModule],
    declarations: []
})
export class JobsRoutingModule {
}
