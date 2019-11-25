// @ts-ignore
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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


const routes: Routes = [
  {
    path: 'connexionPage',
    component: ConnectionComponent
  },
  {
    path:'home',
    component: HomeComponent
  },
  {
    path: 'monitoring',
    component: MonitoringComponent
  },
  {
    path: 'panne',
    component: PanneComponent
  },
  {
    path: 'gestionObject',
    component: GestionObjectComponent
  },
  {
    path: 'activityAnalysis',
    component: ActivityAnalysisComponent
  },
  {
    path: 'location',
    component: LocationComponent
  },
  {
    path: 'medicalControl',
    component: MedicalControlComponent
  },
  {
    path: 'billing',
    component: BillingComponent
  },
  {
    path: 'resident',
    component: ResidentComponent
  }

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
