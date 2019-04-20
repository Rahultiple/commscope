import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders} from '@angular/common/http';
import { SearchForm ,SearchFormOutput} from '../interface';
import {Http, Headers} from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class AuditSearchService {
  private BASEURL=window['cfgApiBaseUrl'];
  URL:string=this.BASEURL+"/API_AUDIT_GET_EXCEL";
  searchData:SearchForm;
  private httpOptions = {

    headers: new HttpHeaders({

    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin':'*'
    })

    };
  constructor(private httpClient:HttpClient) {
    console.log("Window url->"+window["cfgApiBaseUrl"]);
      console.log("Window url->"+this.BASEURL);
  }
  callAuditSearch(jsonBody:SearchForm):Observable<SearchFormOutput>{
     let searchFormObj = this.httpClient.post<SearchFormOutput>(this.URL,jsonBody,this.httpOptions);
     return searchFormObj;
  }
}
