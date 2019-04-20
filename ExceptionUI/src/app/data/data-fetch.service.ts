import { Injectable } from '@angular/core';
import {  HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Inteface1 } from '../interface';
// tslint:disable-next-line:comment-format
//import 'rxjs/add/operator/toPromise';

@Injectable({
  providedIn: 'root'
})
export class DataFetchService  {

   obj:Observable<Inteface1>;
   globalData:Inteface1;
  constructor(private httpClient:HttpClient) {
  }
    fetchService():Inteface1{
       //return  this.httpClient.get<Inteface1>("https://jsonplaceholder.typicode.com/todos/1");

       //this.obj.subscribe((data)=>{this.globalData=data});
       //console.log("data=> "+this.globalData);
       //return this.obj;
        this.obj =  this.httpClient.get<Inteface1>("https://jsonplaceholder.typicode.com/todos/1");
        this.obj.subscribe((inf)=>{
            console.log("inside the data "+inf.id);
            this.globalData=inf;
            return this.globalData;
            },
            (errorData)=>{
                console.log("Error coming ->"+errorData);
                return null;
            },
            ()=>{
                console.log("---finished----");

                return this.globalData;
            }
            );
            return null;
    }
    fetchServiceObservable():Observable<Inteface1>{
       //return  this.httpClient.get<Inteface1>("https://jsonplaceholder.typicode.com/todos/1");

       //this.obj.subscribe((data)=>{this.globalData=data});
       //console.log("data=> "+this.globalData);
       //return this.obj;
        this.obj =  this.httpClient.get<Inteface1>("https://jsonplaceholder.typicode.com/todos/1");
        return this.obj
    }
    getPromise(){
            /* let promise=new Promise(
                function(resolve,reject){

                }

            ); */
            let  promise= new Promise(
                function(resolve,reject){
                    console.log("then");

                }

            );

    }

    fetchLocalService():Observable<any>{

        let obj =  this.httpClient.get<Inteface1>("https://jsonplaceholder.typicode.com/todos/1");
        obj.subscribe(function(response){
                console.log("In success respose");
        },
        function error(errorMSG){
                console.log("In falure respose");
        });
        return this.obj

    }

}
