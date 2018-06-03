import {Component, Input, OnInit} from '@angular/core';
import {StackExchangeWrapper} from "../../model/StackExchangeWrapper";

@Component({
  selector: 'app-table-items-find',
  templateUrl: './table-items-find.component.html',
  styleUrls: ['./table-items-find.component.css']
})
export class TableItemsFindComponent implements OnInit {
  @Input()
  wrapp: StackExchangeWrapper;

  constructor() { }

  ngOnInit() {
  }

}
