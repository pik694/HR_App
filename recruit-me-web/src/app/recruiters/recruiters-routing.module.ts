import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {RecruitersFormComponent} from './recruiters-form/recruiters-form.component';
import {RecruitersDetailsComponent} from './recruiters-details/recruiters-details.component';
import {RecruitersListComponent} from './recruiters-list/recruiters-list.component';

const routes: Routes = [
    {
        path: 'edit/:id',
        component: RecruitersFormComponent,
    },
    {
        path: 'create',
        component: RecruitersFormComponent,
    },
    {
        path: ':id',
        component: RecruitersDetailsComponent,
    },
    {
        path: '',
        component: RecruitersListComponent,
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
export class RecruitersRoutingModule {
}
