import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { WipfPunktePagePage } from './wipf-punkte-page.page';

const routes: Routes = [
  {
    path: '',
    component: WipfPunktePagePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WipfPunktePagePageRoutingModule {}
