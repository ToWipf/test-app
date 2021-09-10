import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'wipfStartPage',
        loadChildren: () => import('../wipfStartPage/wipfStartPage.module').then(m => m.WipfStartPageModule)
      },
      {
        path: 'wipfInfoPage',
        loadChildren: () => import('../wipfInfoPage/wipfInfoPage.module').then(m => m.WipfInfoPageModule)
      },
      {
        path: 'wipfAboutPage',
        loadChildren: () => import('../wipfAboutPage/wipfAboutPage.module').then(m => m.WipfAboutPageModule)
      },
      {
        path: 'wipfTelegramSyncPage',
        loadChildren: () => import('../wipf-sync-telegram-page/wipf-sync-telegram-page.module').then(m => m.WipfSyncTelegramPagePageModule)
      },
      {
        path: '',
        redirectTo: '/tabs/wipfStartPage',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/wipfStartPage',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule { }
