import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { WipfSyncTelegramPagePage } from './wipf-sync-telegram-page.page';

const routes: Routes = [
  {
    path: '',
    component: WipfSyncTelegramPagePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WipfSyncTelegramPagePageRoutingModule {}
