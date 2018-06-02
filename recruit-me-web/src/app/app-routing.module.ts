import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {PageNotFoundComponent} from './other/page-not-found/page-not-found.component';

const appRoutes: Routes = [
    // { path: 'applicants', component: ApplicantsListComponent },

    {   path: '',
        redirectTo: '/jobs',
        pathMatch: 'full'
    },
    {
        path: 'users',
        loadChildren: './users/users.module#UsersModule'
    },
    {
        path: 'processes',
        loadChildren: './processes/processes.module#ProcessesModule'
    },
    {
        path: 'jobs',
        loadChildren: './jobpostings/jobpostings.module#JobPostingsModule'
    },
    {
        path: 'applicants',
        loadChildren: './applicants/applicants.module#ApplicantsModule'
    },

    {path: '**', component: PageNotFoundComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes, {
        preloadingStrategy: PreloadAllModules
    })],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
