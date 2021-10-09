import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'wipf-sync-telegram-page',
    loadChildren: () => import('./wipf-sync-telegram-page/wipf-sync-telegram-page.module').then( m => m.WipfSyncTelegramPagePageModule)
  },
  {
    path: 'wipf-punkte-page',
    loadChildren: () => import('./wipf-punkte-page/wipf-punkte-page.module').then( m => m.WipfPunktePagePageModule)
  }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
