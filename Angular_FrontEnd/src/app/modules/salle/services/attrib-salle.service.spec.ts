import { TestBed } from '@angular/core/testing';

import { AttribSalleService } from './attrib-salle.service';

describe('AttribSalleService', () => {
  let service: AttribSalleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AttribSalleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
