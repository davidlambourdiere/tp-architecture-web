// @ts-ignore
import { BrowserModule } from '@angular/platform-browser';
// @ts-ignore
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonComponent } from './components/person/person.component';

// @ts-ignore
import {HttpClientModule} from '@angular/common/http';
import {HeadComponent} from './components/head/head.component';
import {HomeComponent} from './components/home/home.component';
import {ConnectionComponent} from './components/connection/connection.component';

@NgModule({
  declarations: [
    AppComponent,
    HeadComponent,
    PersonComponent,
    HomeComponent,
    ConnectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
