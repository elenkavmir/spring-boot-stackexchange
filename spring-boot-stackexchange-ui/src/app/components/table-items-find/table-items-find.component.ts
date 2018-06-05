import {Component, OnInit} from '@angular/core';
import {StackExchangeWrapper} from "../../domain/StackExchangeWrapper";
import {StackExchangeServiceService} from "../../services/stack-exchange-service.service";
import {ActivatedRoute} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-table-items-find',
  templateUrl: './table-items-find.component.html',
  styleUrls: ['./table-items-find.component.css']
})
export class TableItemsFindComponent implements OnInit {
  /**
   * Строка поиска
   */
  title: string;
  /**
   * Страница поиска
   * @type {number}
   */
  page: number = 1;
  /**
   * Размер страницы поиска
   * @type {number}
   */
  pagesize: number = 100;
  /**
   * Ответ
   */
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

  /**
   * Поиск вопросов
   */
  search() {
    if (!this.title)
      alert("Строка поиска не может быть пустой!");
    this.stackExchangeServiceService.getQuestions(this.title, this.page, this.pagesize).subscribe(data => {
        this.wrapp = data as StackExchangeWrapper;
        this.stackExchangeServiceService.setHasMore(this.wrapp.has_more);
        if (this.wrapp.error_message)
          alert("Запрос вернул ошибку: " + this.wrapp.error_message);
      },
      error => {
        if (error instanceof HttpErrorResponse)
          alert("Ошибка запроса: " + this.stackExchangeServiceService.errorRquestToString(error));
        else
          alert("Ошибка запроса: " + error);
      });
  }
}
