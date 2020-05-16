// @ts-ignore
import {NgModule} from '@angular/core';

import {ConnectionComponent} from './components/connection/connection.component';
import {HomeComponent} from './components/home/home.component';
import {MonitoringComponent} from './components/monitoring/monitoring.component';
import {PanneComponent} from './components/panne/panne.component';
import {GestionObjectComponent} from './components/gestion.object/gestion.object.component';
import {ActivityAnalysisComponent} from './components/activity.analysis/activity.analysis.component';
import {LocationComponent} from './components/location/location.component';
import {MedicalControlComponent} from './components/medical.control/medical.control.component';
import {BillingComponent} from './components/billing/billing.component';
import {ResidentComponent} from './components/resident/resident.component';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuardService} from './guards/auth-guard.service';
import {CustomComponent} from './components/subscription/custom.component';
import {ConfortComponent} from './components/subscription/confort/confort.component';
import {EssentialComponent} from './components/subscription/essential/essential.component';
import {SerenityComponent} from './components/subscription/serenity/serenity.component';
import {TotalconfortComponent} from './components/subscription/totalconfort/totalconfort.component';
import {NotificationComponent} from "./components/notification/notification.component";
import {DetailIotComponent} from "./components/monitoring/detail.iot/detail.iot.component";
import {SurveyComponent} from "./components/survey/survey.component";
import {MedicalResidentsComponent} from "./components/medical.control/medical.residents/medical.residents.component";
import {NotificationHeaterComponent} from "./components/notification/notification.heater/notification.heater.component";
import {NotificationShutterComponent} from "./components/notification/notification.shutter/notification.shutter.component";
import {NotificationLightComponent} from "./components/notification/notification.light/notification.light.component";
import {NotificationClockComponent} from "./components/notification/notification.clock/notification.clock.component";
import {NotificationStrapComponent} from "./components/notification/notification.strap/notification.strap.component";
import {NotificationNewComponent} from "./components/notification/notification.new/notification.new.component";
import {NotificationReceivedComponent} from "./components/notification/notification.received.component/notification.received.component";
import {NotificationSentComponent} from "./components/notification/notification.sent.component/notification.sent.component";
import {ReactiveFormsModule} from "@angular/forms";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatSliderModule} from "@angular/material/slider";
import {MatSelectModule} from "@angular/material/select";
import {MatRadioModule} from "@angular/material/radio";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatButtonModule} from "@angular/material/button";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DetailAlertComponent} from "./components/medical.control/detail.alert/detail.alert.component";
import {MedicalProfilComponent} from "./components/medical.control/medical.profil/medical.profil.component";
import {ProfilelistComponent} from "./components/profilelist/profilelist.component";
import {PositionComponent} from "./components/position/position.component";



const routes: Routes = [
  {
    path: '',
    component: ConnectionComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'confort/:login',
    component: ConfortComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'essential/:login',
    component: EssentialComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'serenity/:login',
    component: SerenityComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'total-confort/:login',
    component: TotalconfortComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'monitoring',
    component: MonitoringComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'panne',
    component: PanneComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'gestionObject',
    component: GestionObjectComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'activityAnalysis',
    component: ActivityAnalysisComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'location',
    component: LocationComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'medicalControl',
    component: MedicalControlComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'billing',
    component: BillingComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'resident',
    component: ResidentComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification',
    component: NotificationComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'detailiot/:id/:state',
    component: DetailIotComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'custom',
    component: CustomComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'survey',
    component: SurveyComponent
  },
  {
    path: 'medicalControl/residents',
    component: MedicalResidentsComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/heater/:id',
    component: NotificationHeaterComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/shutter/:id',
    component: NotificationShutterComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/light/:id',
    component: NotificationLightComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/clock/:id',
    component: NotificationClockComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/strap/:id',
    component: NotificationStrapComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/new',
    component: NotificationNewComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/received',
    component: NotificationReceivedComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'notification/sent',
    component: NotificationSentComponent,
    canActivate: [AuthGuardService]
  },
  { path: 'detailalert/:id',
    component: DetailAlertComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'medicalprofil/:id',
    component: MedicalProfilComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'profileList',
    component: ProfilelistComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'position',
    component: PositionComponent
  }

];

// @ts-ignore
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule,
    MatAutocompleteModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
