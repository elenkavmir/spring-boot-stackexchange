import {Component, OnInit} from '@angular/core';
import {StackExchangeServiceService} from "./services/stack-exchange-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title: string;
  page: number = 1;

  constructor(protected stackExchangeServiceService: StackExchangeServiceService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
        if (params['title'])
          this.title = params['title'];
        if (params['page'])
          this.page = params['page'];
      });
  }

  searchIn(page) {
    if (page)
      this.page = (page == 'init') ? 1 : ((page == 'next') ? ++this.page : --this.page);
    this.router.navigate([''], {queryParams: {page: this.page, title: this.title}});
  }

  keyDownFunction(event){
    if(event.keyCode == 13) {
      this.searchIn('init');
    }
  }

  getHasMore() {
    return this.stackExchangeServiceService.getHasMore();
  }
}
