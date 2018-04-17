import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RouterModule, Routes} from "@angular/router";
import { ApplicantsListComponent } from './applicants/applicants-list/applicants-list.component';
import { PageNotFoundComponent } from './other/page-not-found/page-not-found.component';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

const appRoutes: Routes = [
    { path: 'applicants', component: ApplicantsListComponent },
    /*{ path: 'hero/:id',      component: HeroDetailComponent },
    {
        path: 'heroes',
        component: HeroListComponent,
        data: { title: 'Heroes List' }
    },*/
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ApplicantsListComponent,
    PageNotFoundComponent
  ],
  imports: [
    RouterModule.forRoot(
        appRoutes,
        { enableTracing: true } // <-- debugging purposes only
    ),
    NgxDatatableModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
