// @ts-ignore
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ConnectionComponent} from './components/connection/connection.component';
import {HomeComponent} from './components/home/home.component';


const routes: Routes = [
  {
    path: 'connexionPage',
    component: ConnectionComponent
  },
  {
    path:'home',
    component: HomeComponent
  }

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
