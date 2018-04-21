import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {RouterModule} from '@angular/router';

@NgModule({
    imports: [
        CommonModule,
        NgxDatatableModule,
        FormsModule,
        HttpClientModule,
        RouterModule
    ],
    declarations: [],
    exports: [
        NgxDatatableModule,
        FormsModule,
        HttpClientModule,
        RouterModule
    ]
})
export class SharedModule {
}
