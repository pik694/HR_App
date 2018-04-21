import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RecruitersService} from './recruiters.service';
import {RecruitersDetailsComponent} from './recruiters-details/recruiters-details.component';
import {RecruitersFormComponent} from './recruiters-form/recruiters-form.component';
import {RecruitersListComponent} from './recruiters-list/recruiters-list.component';
import {RecruitersRoutingModule} from './recruiters-routing.module';
import {SharedModule} from '../shared/shared.module';
import {InMemoryDataService} from '../in-memory-data.service';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';

@NgModule({
    imports: [
        CommonModule,
        RecruitersRoutingModule,
        SharedModule
    ],
    declarations: [
        RecruitersDetailsComponent,
        RecruitersListComponent,
        RecruitersFormComponent
    ],
    providers: [RecruitersService],
})
export class RecruitersModule {
}
