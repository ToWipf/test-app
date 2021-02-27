import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { WipfTestPageRoutingModule } from './wipf-test-routing.module';

import { WipfTestPage } from './wipf-test.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    WipfTestPageRoutingModule
  ],
  declarations: [WipfTestPage]
})
export class WipfTestPageModule {}
