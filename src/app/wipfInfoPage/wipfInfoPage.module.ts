import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { WipfInfoPage } from './wipfInfoPage.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { WipfInfoPageRoutingModule } from './wipfInfoPage-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    WipfInfoPageRoutingModule
  ],
  declarations: [WipfInfoPage]
})
export class WipfInfoPageModule {}
