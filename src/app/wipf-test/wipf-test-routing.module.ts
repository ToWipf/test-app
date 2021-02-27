import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { WipfTestPage } from './wipf-test.page';

const routes: Routes = [
  {
    path: '',
    component: WipfTestPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WipfTestPageRoutingModule {}
