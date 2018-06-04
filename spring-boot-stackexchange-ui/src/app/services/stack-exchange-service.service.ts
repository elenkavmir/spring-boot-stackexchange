import { Injectable } from '@angular/core';
import {StackExchangeWrapper} from "../model/StackExchangeWrapper";
import {HttpClient, HttpErrorResponse} from "@angular/common/http"
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class StackExchangeServiceService {
  private baseUrl = '';//'http://localhost:8081';
  private hasMore: boolean = false;

  constructor(private http: HttpClient) { }

  getQuestions(title: string, page: number, pagesize: number) {
    let url: string = this.baseUrl + '/api/rest/questions?title=' + (title);
    if (page)
      url += '&page=' + page;
    if (pagesize)
      url += '&pagesize=' + pagesize;
    return this.http.get(url);
  }

  errorRquestToString(error: HttpErrorResponse): string {
    return error.error.status + " " + error.error.error + "\n" + error.error.message + "\nurl = " + error.error.path;
  }


  getHasMore(): boolean {
    return this.hasMore;
  }

  setHasMore(value: boolean) {
    this.hasMore = value;
  }
}
