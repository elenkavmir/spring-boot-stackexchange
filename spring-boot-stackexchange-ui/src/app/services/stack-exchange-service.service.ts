import { Injectable } from '@angular/core';
import {StackExchangeWrapper} from "../model/StackExchangeWrapper";
import {HttpClient} from "@angular/common/http"
import {Observable} from "rxjs/internal/Observable";

@Injectable({
  providedIn: 'root'
})
export class StackExchangeServiceService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getQuestions(findstring: string, offset: number, limit: number) {
    let url: string = this.baseUrl + '/api/rest/questions?findstring=' + findstring;
    if (offset)
      url += '&offset=' + offset;
    if (limit)
      url += '&limit=' + limit;
    return this.http.get(url);
  }
}
