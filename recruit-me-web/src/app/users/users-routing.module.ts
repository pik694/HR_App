import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UsersFormComponent} from './users-form/users-form.component';
import {UsersDetailsComponent} from './users-details/users-details.component';
import {UsersListComponent} from './users-list/users-list.component';

const routes: Routes = [
    {
        path: 'edit/:id',
        component: UsersFormComponent,
    },
    {
        path: 'create',
        component: UsersFormComponent,
    },
    {
        path: ':id',
        component: UsersDetailsComponent,
    },
    {
        path: '',
        component: UsersListComponent,
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
export class UsersRoutingModule {
}
