import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http"
import {Location, PlatformLocation} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class StackExchangeServiceService {
  /**
   * Базовый url
   * @type {string}
   */
  protected baseUrl = '';
  /**
   * Флаг - есть ли еще данные по данному запросу
   * @type {boolean}
   */
  protected hasMore: boolean = false;

  constructor(private http: HttpClient, private location: Location, private platform: PlatformLocation) {
    this.baseUrl = (this.platform as any).location.pathname.slice(0,-1);
    //console.log((this.platform as any).location);
  }

  /**
   * Запрос вопросов
   * @param {string} title - содержимое вопроса
   * @param {number} page - страница поиска
   * @param {number} pagesize - размер страницы поиска
   * @returns {Observable<Object>}
   */
  getQuestions(title: string, page: number, pagesize: number) {
    let url: string = this.baseUrl + '/api/rest/questions?title=' + (title);
    if (page)
      url += '&page=' + page;
    if (pagesize)
      url += '&pagesize=' + pagesize;
    return this.http.get(url);
  }

  /**
   * Преобразование ошибки http в строку
   * @param {HttpErrorResponse} error
   * @returns {string}
   */
  errorRquestToString(error: HttpErrorResponse): string {
    return error.status + " " + error.name + "\n" + error.message +
      (error.error.path) ? (error.error.error + "\nurl = " + error.error.path) : "";
  }


  getHasMore(): boolean {
    return this.hasMore;
  }

  setHasMore(value: boolean) {
    this.hasMore = value;
  }
}
