import { UpdateRow } from './../interface';
import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { Injectable } from '@angular/core';
import {  HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { ExcelReadServiceInterface, SaveRow} from '../interface';
import {Http, Headers} from '@angular/http';
import { stringify } from '@angular/core/src/util';

@Injectable({
  providedIn: "root",
})
export class ExceptionCrudService {
  private BASEURL = window["cfgApiBaseUrl"];
  URL: string = this.BASEURL;
  private subjects: Subject<any>[] = [];
  private httpOptions = {
    headers: new HttpHeaders({
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "*",
    }),
  };
  constructor(private httpClient: HttpClient) {
    console.log("Window url->" + window["cfgApiBaseUrl"]);
    console.log("Window url->" + this.BASEURL);
  }
  callAuditSearch(): Observable<ExcelReadServiceInterface> {
     let url=this.URL+ "/API_READ_ERROR_CODES";
     let searchFormObj = this.httpClient.get<ExcelReadServiceInterface>(
      url
    );
    return searchFormObj;
  }

  callDeleteRow(paramName:string): Observable<ExcelReadServiceInterface> {
    let params = new HttpParams();
    params.set('internalErrorCode', paramName);
    let url=this.URL+ "/API_DELETE_ERROR_CODES?internalErrorCode="+paramName;
    let searchFormObj = this.httpClient.get<ExcelReadServiceInterface>(
      url
    );
    return searchFormObj;
  }
  callSaveRow(jsonBody:SaveRow):Observable<any>{
    let url=this.URL+"/API_INSERT_ERROR_CODES"
    let searchFormObj = this.httpClient.post<any>(url,jsonBody,this.httpOptions);
    return searchFormObj;
 }
 callUpdateRow(jsonBody:UpdateRow):Observable<any>{
  let url=this.URL+"/API_UPDATE_ERROR_CODES"
  let searchFormObj = this.httpClient.post<any>(url,jsonBody,this.httpOptions);
  return searchFormObj;
 }

  publishUpdateRow(eventName: string,eventObject: any) {
    // ensure a subject for the event name exists
    console.log("eventName: "+eventName);
    //console.log("eventObject: "+JSON.stringify(eventObject));
    this.subjects[eventName] = this.subjects[eventName] || new Subject();

    // publish event
    this.subjects[eventName].next(eventObject);
  }


  publishObject(eventName: any,eventObject: any) {
    // ensure a subject for the event name exists
    this.subjects[eventName] = this.subjects[eventName] || new Subject();

    // publish event
    this.subjects[eventName].next(eventObject);
  }

  receiveObject(eventName: any): Observable<any> {
    // ensure a subject for the event name exists
    this.subjects[eventName] = this.subjects[eventName] || new Subject();

    // return observable
    return this.subjects[eventName].asObservable();
  }

}
