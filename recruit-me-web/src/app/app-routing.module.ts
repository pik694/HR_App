import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {PageNotFoundComponent} from './other/page-not-found/page-not-found.component';

const appRoutes: Routes = [
    // { path: 'applicants', component: ApplicantsListComponent },

    {
        path: 'recruiters',
        loadChildren: './recruiters/recruiters.module#RecruitersModule'
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
