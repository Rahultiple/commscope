import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders} from '@angular/common/http';
import { SearchForm ,SearchFormOutput} from '../util/interface';
import {Http, Headers} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class AuditSearchService {

  searchData:SearchForm;
  private httpOptions = {

    headers: new HttpHeaders({

    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin':'*'
    })

    };
  constructor(private httpClient:HttpClient) {

  }
  callAuditSearch(jsonBody:SearchForm):Observable<SearchFormOutput>{
     let searchFormObj = this.httpClient.post<SearchFormOutput>("http://localhost:8080/audit/API_AUDIT_GET_EXCEL"
    ,jsonBody,this.httpOptions);
    return searchFormObj;
  }
}
