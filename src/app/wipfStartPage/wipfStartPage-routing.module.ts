import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WipfStartPage } from './wipfStartPage.page';

const routes: Routes = [
  {
    path: '',
    component: WipfStartPage,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WipfStartPageRoutingModule {}
