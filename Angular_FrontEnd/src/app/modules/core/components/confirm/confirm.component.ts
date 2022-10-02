import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.scss']
})
export class ConfirmComponent implements OnInit {

  @Input() public confirmMessage: string;
  @Output() public confirmResponse: EventEmitter<boolean>
    = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
  }

}
