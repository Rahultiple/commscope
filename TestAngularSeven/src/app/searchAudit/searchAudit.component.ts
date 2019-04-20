import { Observable } from 'rxjs';
import { Component, OnInit, ViewChild } from '@angular/core';
import {  FormGroup,FormControl } from '@angular/forms';
import { AuditSearchService } from '../auditSearchService/audit-search.service';
import { SearchForm,Params,SearchFormOutput } from '../dashboard/interface';
import {BsDatepickerConfig} from 'ngx-bootstrap/datepicker';
import { formatDate, DatePipe } from "@angular/common";

/*
  Rahul Study material
  use following links to study
      1)Video for the angular FormGroup
      https://www.youtube.com/watch?v=VLYc3ACWL-E&index=4&list=PL6n9fhu94yhWNJaDgh0mfae_9xoQ4E_Zj
      2)link for the grid display
      https://medium.com/ag-grid/get-started-with-angular-grid-in-5-minutes-83bbb14fac93
      3)Html design
      https://medium.com/wdstack/bootstrap-4-form-examples-c18ac5e9cd30
      4) For date picker option
         https://www.youtube.com/watch?v=edaN6iCcqP4
         https://www.youtube.com/watch?v=R_QcssTIEr0&t=461s
         https://valor-software.com/ngx-bootstrap/#/datepicker



*/
@Component({
  selector: 'app-searchAudit',
  templateUrl: './searchAudit.component.html',
  styleUrls: ['./searchAudit.component.css']
})
export class SearchAuditComponent implements OnInit {

  datePickerConfig:Partial<BsDatepickerConfig>;
  responseType1:String;
  fromDate:Date;
  searchForm:FormGroup;
  responseTypes: string[] = ["Select","Success", "Failure"];
  columnDefs = [
    {headerName: 'Sender Id', field: 'senderID'},
    {headerName: 'Response Type', field: 'responseType'},
    {headerName: 'Transaction Type', field: 'transactionType'},
    {headerName: 'Response Type', field: 'responseType'},
    {headerName: 'Source Name', field: 'source'},
    {headerName: 'CreatedBy', field: 'createdById'},
    {headerName: 'Message', field: 'responseMessage'}
  ];
  rowData :any;
  pipe:DatePipe;  // Use your own locale
  constructor(private auditService:AuditSearchService) {
    this.datePickerConfig=
      {
         containerClass:'theme-green',
         rangeInputFormat:'YYYY/MM/DD',
         rangeSeparator:"<=FROM : TO=>"
      }
    ;

  }
  ngOnInit() {
       this.searchForm=new FormGroup({
      senderID:new FormControl(),
      responseType:new FormControl(),
      transactionType:new FormControl(),
      sourceName:new FormControl(),
      searchDate:new FormControl(),
      start_date:new FormControl(),
      end_date:new FormControl(),
    });
   }

  onSubmit(){
      console.log("Search Form: "+JSON.stringify(this.searchForm.value));
      let senderId=this.searchForm.value.senderId
      this.searchForm.value.responseType=this.searchForm.value.responseType=="Select"?null:this.searchForm.value.responseType
      console.log("-->"+this.searchForm.value.responseType);
      let responseType=this.searchForm.value.responseType;
      let transactionType=this.searchForm.value.transactionType;
      let sourceName=this.searchForm.value.sourceName;
      if (this.searchForm.value.searchDate != null) {
        let fromDate = this.formatDates(this.searchForm.value.searchDate[0]);
        let toDate = this.formatDates(this.searchForm.value.searchDate[1]);
        console.log(fromDate + "xxx-->" + toDate);
        this.searchForm.value.start_date = fromDate;
        this.searchForm.value.end_date = toDate;
      }
      let observableService:Observable<SearchFormOutput> = this.auditService.callAuditSearch(this.searchForm.value);
      observableService.subscribe(
        (searchFormValue: SearchFormOutput) =>{
          console.log("success "+searchFormValue);
          console.log("value-> "+JSON.stringify(searchFormValue));
          this.rowData =searchFormValue.listExcelMessage;
        },
        (error: any) => {
          console.log("error ");
        },
         () =>{
            console.log("completed ");
         } );

  }
 formatDates(date:Date):String{
    var d = date;
     let   month = '' + (d.getMonth() + 1);
     let  day = '' + d.getDate();
     let   year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
}

}
