import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ApplicantsFormComponent} from './applicants-form/applicants-form.component';
import {ApplicantsDetailsComponent} from './applicants-details/applicants-details.component';
import {ApplicantsListComponent} from './applicants-list/applicants-list.component';

const routes: Routes = [
    {
        path: 'edit/:id',
        component: ApplicantsFormComponent,
    },
    {
        path: 'create',
        component: ApplicantsFormComponent,
    },
    {
        path: ':id',
        component: ApplicantsDetailsComponent,
    },
    {
        path: '',
        component: ApplicantsListComponent,
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
export class ApplicantsRoutingModule {
}
