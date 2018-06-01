import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {RouterModule} from '@angular/router';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemoryDataService} from '../in-memory-data.service';
import { ProcessFormComponent } from './process-form/process-form.component';

@NgModule({
    imports: [
        CommonModule,
        NgxDatatableModule,
        FormsModule,
        HttpClientModule,
        RouterModule,
        //HttpClientInMemoryWebApiModule.forRoot(InMemoryDataService),
    ],
    declarations: [ProcessFormComponent],
    exports: [
        NgxDatatableModule,
        FormsModule,
        HttpClientModule,
        RouterModule
    ]
})
export class SharedModule {
}
