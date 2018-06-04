import {Component, OnInit} from '@angular/core';
import {StackExchangeWrapper} from "../../model/StackExchangeWrapper";
import {StackExchangeServiceService} from "../../services/stack-exchange-service.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-table-items-find',
  templateUrl: './table-items-find.component.html',
  styleUrls: ['./table-items-find.component.css']
})
export class TableItemsFindComponent implements OnInit {
  title: string;
  page: number = 1;
  pagesize: number = 100;
  wrapp: StackExchangeWrapper;

  constructor(protected stackExchangeServiceService: StackExchangeServiceService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
        if (params['title'])
          this.title = params['title'];
        if (params['page'])
          this.page = params['page'];
        if (this.title)
          this.search();
      });
  }

  search() {
    if (!this.title)
      alert("Строка поиска не может быть пустой!");
    this.stackExchangeServiceService.getQuestions(this.title, this.page, this.pagesize).subscribe(data => {
        this.wrapp = data as StackExchangeWrapper;
        this.stackExchangeServiceService.setHasMore(this.wrapp.has_more);
      },
      error => {
        alert("Ошибка запроса: " + this.stackExchangeServiceService.errorRquestToString(error))
      });
  }
}
