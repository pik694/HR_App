import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import { ApplicantsListComponent } from './applicants/applicants-list/applicants-list.component';
import { PageNotFoundComponent } from './other/page-not-found/page-not-found.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import { RecruitersListComponent } from './recruiters/recruiters-list/recruiters-list.component';
import { RecruitersFormComponent } from './recruiters/recruiters-form/recruiters-form.component';
import {FormsModule} from '@angular/forms';
import {RecruitersService} from './recruiters/recruiters.service';
import {routes} from './routes';
import { RecruitersDetailsComponent } from './recruiters/recruiters-details/recruiters-details.component';
import {HttpClientModule} from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';

const appRoutes: Routes = [
    { path: routes.APPLICANTS_BASE_ROUTE, component: ApplicantsListComponent },

    { path: routes.RECRUITERS_CREATE_ROUTE, component: RecruitersFormComponent },
    { path: routes.RECRUITERS_EDIT_ROUTE + '/:id', component: RecruitersFormComponent },
    { path: routes.RECRUITERS_BASE_ROUTE + '/:id', component: RecruitersDetailsComponent },
    { path: routes.RECRUITERS_BASE_ROUTE, component: RecruitersListComponent },

    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ApplicantsListComponent,
    PageNotFoundComponent,
    RecruitersListComponent,
    RecruitersFormComponent,
    RecruitersDetailsComponent
  ],
  imports: [
    RouterModule.forRoot(
        appRoutes,
        { enableTracing: true } // <-- debugging purposes only
    ),
    NgxDatatableModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
        InMemoryDataService, { dataEncapsulation: false }
    )
  ],
  providers: [RecruitersService],
  bootstrap: [AppComponent]
})
export class AppModule { }
