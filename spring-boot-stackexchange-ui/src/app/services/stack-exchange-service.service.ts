import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http"
import {Location, PlatformLocation} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class StackExchangeServiceService {
  private baseUrl = '';//'http://localhost:8081';
  private hasMore: boolean = false;

  constructor(private http: HttpClient, private location: Location, private platform: PlatformLocation) {
    this.baseUrl = (this.platform as any).location.pathname;
    console.log((this.platform as any).location);
    console.log((this.platform as any).location.href);
    console.log((this.platform as any).location.origin);
    console.log(this.baseUrl);
  }

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
