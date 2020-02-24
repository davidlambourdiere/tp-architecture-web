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
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MonitoringComponent} from './components/monitoring/monitoring.component';
import {PanneComponent} from './components/panne/panne.component';
import {GestionObjectComponent} from './components/gestion.object/gestion.object.component';
import {ActivityAnalysisComponent} from './components/activity.analysis/activity.analysis.component';
import {LocationComponent} from './components/location/location.component';
import {MedicalControlComponent} from './components/medical.control/medical.control.component';
import {ResidentComponent} from './components/resident/resident.component';
import {AuthService} from "./service/AuthService";
import {NotificationComponent} from "./components/notification/notification.component";
import {DetailIotComponent} from "./components/monitoring/detail.iot/detail.iot.component";
import { SubscriptionComponent } from './components/subscription/subscription.component';
import {BillingComponent} from "./components/billing/billing.component";
import {SurveyComponent} from "./components/survey/survey.component";
import { MedicalHomeComponent} from './components/medical.control/medical.home/medical.home.component';
import { MedicalMenuComponent } from './components/medical.control/medical.menu/medical.menu.component';
import { MedicalResidentsComponent } from './components/medical.control/medical.residents/medical.residents.component';

@NgModule({
  declarations: [
    AppComponent,
    HeadComponent,
    PersonComponent,
    HomeComponent,
    ConnectionComponent,
    MonitoringComponent,
    PanneComponent,
    NotificationComponent,
    DetailIotComponent,
    GestionObjectComponent,
    ActivityAnalysisComponent,
    LocationComponent,
    MedicalControlComponent,
    BillingComponent,
    ResidentComponent,
    SubscriptionComponent,
    SurveyComponent,
    MedicalHomeComponent,
    MedicalMenuComponent,
    MedicalResidentsComponent,
    SurveyComponent
  ],
  imports: [
    // NgbModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
