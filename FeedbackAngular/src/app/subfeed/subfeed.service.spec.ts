import { TestBed } from '@angular/core/testing';

import { SubfeedService } from './subfeed.service';

describe('SubfeedService', () => {
  let service: SubfeedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubfeedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
