import { NgModule } from '@angular/core';
import { WipfStartPage } from './wipfStartPage.page';

import { WipfStartPageRoutingModule } from './wipfStartPage-routing.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    WipfStartPageRoutingModule
  ],
  declarations: [WipfStartPage]
})
export class WipfStartPageModule {}
