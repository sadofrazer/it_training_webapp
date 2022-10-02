import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CoreRoutingModule } from './core-routing.module';
import { ItemsListComponent } from './components/items-list/items-list.component';
import { ConfirmComponent } from './components/confirm/confirm.component';
import { ConfirmDirective } from './directives/confirm.directive';


@NgModule({
  declarations: [
    ItemsListComponent,
    ConfirmComponent,
    ConfirmDirective
  ],
  imports: [
    CommonModule,
    CoreRoutingModule,
    NgbModule
  ],
  exports: [
    ItemsListComponent,
    ConfirmComponent,
    ConfirmDirective
  ]
})
export class CoreModule { }
