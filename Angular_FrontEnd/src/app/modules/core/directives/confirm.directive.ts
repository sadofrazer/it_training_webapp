import { Directive, EventEmitter, HostBinding, HostListener, Input, Output } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmComponent } from '../components/confirm/confirm.component';

@Directive({
  selector: '[appConfirm]'
})
export class ConfirmDirective {

  @Input() public confirmMessage: string;
  @Output() public confirmClick = new EventEmitter<void>();

  // HostListener est un décorateur
  // qui permets de s'abonner à un évenement Javascript.
  // Lorsque cet événement est appelé, la méthode associée
  // est exécutée.
  @HostListener('click')
  public onClick(): void {
    // Ouverture de la modale avec comme contenu le ConfirmComponent
    const modalRef: NgbModalRef =
      this.ngbModal.open(ConfirmComponent);

    // Récupération de l'instance du ConfirmComponent
    const componentInstance: ConfirmComponent = modalRef.componentInstance;

    // "Binding" de l'input confirmMessage
    componentInstance.confirmMessage = this.confirmMessage;

    // On souscrit à l'output (événement de click sur les boutons Oui/Non)
    componentInstance.confirmResponse.subscribe((b: boolean) => {

      // Si l'utilisateur clique sur Oui, on émets l'output
      if (b == true) {
        this.confirmClick.emit();
      }

      // Fermeture de la modal que l'on clique sur Oui ou sur Non
      modalRef.close();
    });
  }

  constructor(private ngbModal: NgbModal) { }
}
