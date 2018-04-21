import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UsersService} from './users.service';
import {UsersDetailsComponent} from './users-details/users-details.component';
import {UsersFormComponent} from './users-form/users-form.component';
import {UsersListComponent} from './users-list/users-list.component';
import {UsersRoutingModule} from './users-routing.module';
import {SharedModule} from '../shared/shared.module';

@NgModule({
    imports: [
        CommonModule,
        UsersRoutingModule,
        SharedModule
    ],
    declarations: [
        UsersDetailsComponent,
        UsersListComponent,
        UsersFormComponent
    ],
    providers: [UsersService],
})
export class UsersModule {
}
