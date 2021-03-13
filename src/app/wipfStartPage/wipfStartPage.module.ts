import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WipfStartPage } from './wipfStartPage.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { WipfStartPageRoutingModule } from './wipfStartPage-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    WipfStartPageRoutingModule
  ],
  declarations: [WipfStartPage]
})
export class WipfStartPageModule {}
