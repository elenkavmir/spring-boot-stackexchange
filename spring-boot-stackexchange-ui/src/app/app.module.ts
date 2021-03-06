import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule }    from '@angular/common/http';

import { AppComponent } from './app.component';
import { TableItemsFindComponent } from './components/table-items-find/table-items-find.component';
import {RouterModule, Routes} from "@angular/router";

const appRoutes: Routes = [
  {path: '', component: TableItemsFindComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    TableItemsFindComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
