import { TestBed } from '@angular/core/testing';

import { AuditSearchService } from './audit-search.service';

describe('AuditSearchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));


  it('should be created', () => {
    const service: AuditSearchService = TestBed.get(AuditSearchService);
    expect(service).toBeTruthy();
  });
});
