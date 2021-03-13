import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { WipfAboutPage } from './wipfAboutPage.page';

import { WipfAboutPageRoutingModule } from './wipfAboutPage-routing.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: WipfAboutPage }]),
    WipfAboutPageRoutingModule,
  ],
  declarations: [WipfAboutPage]
})
export class WipfAboutPageModule {}
