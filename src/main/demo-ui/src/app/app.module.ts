// @ts-ignore
import { BrowserModule } from '@angular/platform-browser';
// @ts-ignore
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonComponent } from './components/person/person.component';

// @ts-ignore
import {HttpClientModule} from '@angular/common/http';
import { SensorComponent } from './components/sensor/sensor.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    SensorComponent
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
