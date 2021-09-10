import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { WipfSyncTelegramPagePageRoutingModule } from './wipf-sync-telegram-page-routing.module';

import { WipfSyncTelegramPagePage } from './wipf-sync-telegram-page.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    WipfSyncTelegramPagePageRoutingModule
  ],
  declarations: [WipfSyncTelegramPagePage]
})
export class WipfSyncTelegramPagePageModule {}
