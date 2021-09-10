import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { WipfSyncTelegramPagePage } from './wipf-sync-telegram-page.page';

describe('WipfSyncTelegramPagePage', () => {
  let component: WipfSyncTelegramPagePage;
  let fixture: ComponentFixture<WipfSyncTelegramPagePage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ WipfSyncTelegramPagePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(WipfSyncTelegramPagePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
