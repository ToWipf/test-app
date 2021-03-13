import { NgModule } from '@angular/core';
import { WipfInfoPage } from './wipfInfoPage.page';

import { WipfInfoPageRoutingModule } from './wipfInfoPage-routing.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    WipfInfoPageRoutingModule
  ],
  declarations: [WipfInfoPage]
})
export class WipfInfoPageModule {}
