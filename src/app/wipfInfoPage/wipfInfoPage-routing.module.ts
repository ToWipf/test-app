import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WipfInfoPage } from './wipfInfoPage.page';

const routes: Routes = [
  {
    path: '',
    component: WipfInfoPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WipfInfoPageRoutingModule { }
