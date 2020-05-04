// @ts-ignore
import { BrowserModule } from '@angular/platform-browser';
// @ts-ignore
import { NgModule } from '@angular/core';
import {FlexLayoutModule} from '@angular/flex-layout';

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

import {BillingComponent} from "./components/billing/billing.component";
import {SurveyComponent} from "./components/survey/survey.component";
import { EssentialComponent } from './components/subscription/essential/essential.component';
import { TotalconfortComponent } from './components/subscription/totalconfort/totalconfort.component';
import { SerenityComponent } from './components/subscription/serenity/serenity.component';
import {ConfortComponent} from "./components/subscription/confort/confort.component";
import {CustomComponent} from "./components/subscription/custom.component";


import { MedicalHomeComponent} from './components/medical.control/medical.home/medical.home.component';
import { MedicalMenuComponent } from './components/medical.control/medical.menu/medical.menu.component';
import { MedicalResidentsComponent } from './components/medical.control/medical.residents/medical.residents.component';
import { DetailAlertComponent } from './components/medical.control/detail.alert/detail.alert.component';
import {ChartsModule} from "ng2-charts";
import { DatePipe } from '@angular/common';
import {MedicalProfilComponent} from "./components/medical.control/medical.profil/medical.profil.component";
import {ProfilelistComponent} from "./components/profilelist/profilelist.component";



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
    CustomComponent,
    SurveyComponent,
    ConfortComponent,
    EssentialComponent,
    TotalconfortComponent,
    SerenityComponent,
    SurveyComponent,
    MedicalHomeComponent,
    MedicalMenuComponent,
    MedicalResidentsComponent,
    SurveyComponent,
    DetailAlertComponent,
    MedicalProfilComponent,
    ProfilelistComponent

  ],
  imports: [
    // NgbModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    ChartsModule
  ],
  providers: [AuthService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
