import { Component } from '@angular/core';
import {StackExchangeWrapper} from "./model/StackExchangeWrapper";
import {StackExchangeServiceService} from "./services/stack-exchange-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  findstring: string;
  page: number = 1;
  limit: number = 10;
  wrapp: StackExchangeWrapper;

  constructor(protected stackExchangeServiceService: StackExchangeServiceService) {}

  searchIn(page) {
    this.page = (page == 'init') ? 1 : ((page == 'next') ? ++this.page : --this.page);
    this.stackExchangeServiceService.getQuestions(this.findstring, this.page, this.limit).subscribe(data => {
      this.wrapp = data as StackExchangeWrapper;
    }, error => alert("Ошибка запроса: " + error));
  }
}
