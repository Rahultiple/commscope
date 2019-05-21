import { Component, OnInit, AfterContentInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataFetchService } from '../data/data-fetch.service';
import { Observable } from 'rxjs';
import { Inteface1 } from './interface';
import { Select2OptionData } from 'ng2-select2';

@Component({
  selector: 'app-dashboard',
  templateUrl: "./dashboard.component.html",
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit, AfterContentInit {
  symbol: string;
  input_Name: String = "set Text";
  Hitme: String = "rahul";
  obj: Observable<Inteface1>;
  idk: Inteface1;
  inf: Inteface1;
  data: any;
  title: String;
  userId: Number;
  id: Number;
  httpClient: HttpClient;
  selectBox: String;
  symbols: String[] = ["avc", "frrr", "rertret"];
  myCountryData: Array<Select2OptionData>;
  myActiveBhisi:Array<Select2OptionData>;
  myCountryDataLen: number;
  public options: Select2Options;
  countryName: String;
  state_list: String[];
   address: String ;
   startDate : String ;
   bhisNo :Number;

  constructor(private dataBoard: DataFetchService, httpClient: HttpClient) {
    /* this.id=10;
    this.userId=10;
    this.title="3343";
    this.httpClient=httpClient; */

    let data = dataBoard.fetchService();
    console.log("hi-> " + data);
    if (data != null) {

      this.id = data.id;
      this.userId = data.userId;
    }
    this.myActiveBhisi=[
      {
        id: "ganesh",
        text: "Ganesh Bhisi",
        additional: {
          Address: " House No 32 ,Girad ,Teh :samudrapur , Wardha",
          Start_Date:"02-03-1983",
          Bhisi_No:5
        }
      },
      {
        id: "yerunkar",
        text: "Yerunkar Bhisi",
        additional: {
          Address: "Ram Mandir Ward ,Girad ,Teh :samudrapur , Wardha",
          Start_Date:"02-03-1983",
          Bhisi_No:5
        }
      }
    ];
    this.myCountryData = [
      {
        id: "india",
        text: "India",
        additional: {
          states: ["maharastra", "MP", "chattasgadh", "hariyana"]
        },

      },
      {
        id: "japan",
        text: "Japan",
        additional: {
          states: ["Japan-1", "Japan-2", "Japan-3", "Japan-4"]
        }
      },
      {
        id: "neth",
        text: "Netheland",
        additional: {
          states: ["paat", "neth2", "neth3", "neth5"]
        }
      },
      {
        id: "usa",
        text: "USA",
        additional: {
          states: ["usa-1", "usa-3", "usa-4", "usa-5"]
        }
      }];

    console.log("my country data ->" + this.myCountryData.length);

  }

  ngOnInit() {
    let objervable = this.dataBoard.fetchServiceObservable();
    objervable.subscribe(
      (respose) => {
        this.id = respose.id;
        this.userId = respose.userId;
        this.title = respose.title;
      },
      (error) => {
        console.log(error);
      }
    );

    // my code strts
    // my code starts

    this.options = {
      multiple: false,
      theme: 'classic',
      closeOnSelect: false,
      matcher: function (term: string, text: string, option: any) {
        console.log("term: " + term + " text: " + text + " length: " + length);
        console.log("option: " + option);
        let countryObj = text;
        if (countryObj.toLowerCase().search(term.toLowerCase()) != -1) {
          option.selected = true;
          return true;
        }

        return false;

      }
    };

  }
  callChange(event: any) {
    console.log(event);
    let myvalue = event.value;
    myvalue = event.data[0].text;
    console.log("my value is -> " + myvalue);
    this.countryName = myvalue;
    this.state_list = event.data[0].additional.states;
  }
  selectActiveBhisi(event: any) {
    //https://bootsnipp.com/snippets/nNg98`

    console.log(event);
    let myvalue = event.value;
    myvalue = event.data[0].text;
    console.log("my value is -> " + myvalue);
    this.countryName = myvalue;
    this.address = event.data[0].additional.Address;
    this.startDate = event.data[0].additional.Start_Date;
    this.bhisNo = event.data[0].additional.Bhisi_No;
    alert(" Address :: "+ this.address+" startDate::"+ this.startDate+" bhisNo:: "+this.bhisNo);
    location.href="bidding";
  }

  ngAfterContentInit(): void {
    this.selectBox = this.symbols[0];
    console.log("value -> " + this.selectBox);
    jQuery('#symbolId').on('change', (event) => {
      const jQueryObj = jQuery(event);
      const myobj: any = event.target;
      const symbolSelected = event.target.id;
      console.log("symbolSelected- > " + symbolSelected);
      const myval = myobj.value;
      console.log("myobj- > " + myval);
      console.log("myobj- > " + jQueryObj);
      // you can use the selected value
    });
    const myvalue = jQuery('#symbolId').attr("value");
    console.log("value -> " + myvalue);


  }

  sendback() {
    location.href = "";
  }

  goToDetailPage(eventVal: any) {
    location.href = "details";
    let myVal = eventVal.target.value;
    console.log("my value : " + myVal);
  }

}


