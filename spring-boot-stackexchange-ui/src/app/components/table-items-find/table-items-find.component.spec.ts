import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableItemsFindComponent } from './table-items-find.component';

describe('TableItemsFindComponent', () => {
  let component: TableItemsFindComponent;
  let fixture: ComponentFixture<TableItemsFindComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableItemsFindComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableItemsFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
