import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WipfAboutPage } from './wipfAboutPage.page';

const routes: Routes = [
  {
    path: '',
    component: WipfAboutPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WipfAboutPageRoutingModule {}
