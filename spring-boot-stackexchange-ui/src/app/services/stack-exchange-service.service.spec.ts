import { TestBed, inject } from '@angular/core/testing';

import { StackExchangeServiceService } from './stack-exchange-service.service';

describe('StackExchangeServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StackExchangeServiceService]
    });
  });

  it('should be created', inject([StackExchangeServiceService], (service: StackExchangeServiceService) => {
    expect(service).toBeTruthy();
  }));
});
