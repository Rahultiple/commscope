import { Observable } from 'rxjs';
import { Component, OnInit, ViewChild } from '@angular/core';
import {  FormGroup,FormControl } from '@angular/forms';
import { AuditSearchService } from '../auditSearchService/audit-search.service';
import { ExcelFormat,SearchForm,Params,SearchFormOutput } from '../interface';
import {BsDatepickerConfig} from 'ngx-bootstrap/datepicker';
import { formatDate, DatePipe } from "@angular/common";
import { ExcelServiceService } from '../auditSearchService/excel-service.service'
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
      5) for the Excel Export
          https://medium.com/@madhavmahesh/exporting-an-excel-file-in-angular-927756ac9857

        https://www.youtube.com/watch?v=Fda_EJYra-c

*/
@Component({
  selector: "app-searchAudit",
  templateUrl: "./searchAudit.component.html",
  styleUrls: ["./searchAudit.component.css"],
})
export class SearchAuditComponent implements OnInit {
  datePickerConfig: Partial<BsDatepickerConfig>;
  responseType1: String;
  fromDate: Date;
  searchForm: FormGroup;
  showGrid: boolean = false;
  myHeaderHeight: String;
  dateModifiedExcelList:SearchForm[];
  excelDataArray:ExcelFormat[]=[];
  excelFormat:ExcelFormat;
  loadingFlag:boolean=false;
  responseTypes: string[] = ["Select", "Success", "Failure"];
  flagNoData: boolean = true;
  columnDefs = [
    { headerName: "Sender Id", field: "senderID" },
    { headerName: "Response Type", field: "responseType" },
    { headerName: "Transaction Type", field: "transactionType" },
    { headerName: "Id Number", field: "idNumber" },
    { headerName: "Source Name", field: "source" },
    { headerName: "CreatedBy", field: "createdById" },
    { headerName: "Message", field: "responseMessage" },
    { headerName: "Date(YYYY-MM-DD)", field: "dateCellValue" },
  ];
  rowData: any;
  pipe: DatePipe; // Use your own locale
  constructor(private auditService: AuditSearchService,private excelService:ExcelServiceService) {
    this.datePickerConfig = {
      containerClass: "theme-green",
      rangeInputFormat: "YYYY/MM/DD",
      rangeSeparator: "<=FROM : TO=>",
    };
  }
  ngOnInit() {
    this.searchForm = new FormGroup({
      senderID: new FormControl(),
      responseType: new FormControl(),
      transactionType: new FormControl(),
      sourceName: new FormControl(),
      searchDate: new FormControl(),
      start_date: new FormControl(),
      end_date: new FormControl(),
      idNumber: new FormControl()
    });
  }

  onSubmit() {
    this.loadingFlag=true;
    this.showGrid = true;
    console.log("Search Form: " + JSON.stringify(this.searchForm.value));
    let senderId = this.searchForm.value.senderId;
    this.searchForm.value.responseType =
      this.searchForm.value.responseType == "Select"
        ? null
        : this.searchForm.value.responseType;
    console.log("-->" + this.searchForm.value.responseType);
    let responseType = this.searchForm.value.responseType;
    let transactionType = this.searchForm.value.transactionType;
    let sourceName = this.searchForm.value.sourceName;
    if (this.searchForm.value.searchDate != null) {
      let fromDate = this.formatDates(this.searchForm.value.searchDate[0]);
      let toDate = this.formatDates(this.searchForm.value.searchDate[1]);
      console.log(fromDate + "xxx-->" + toDate);
      this.searchForm.value.start_date = fromDate;
      this.searchForm.value.end_date = toDate;
    }
    let observableService: Observable<
      SearchFormOutput
    > = this.auditService.callAuditSearch(this.searchForm.value);
    observableService.subscribe(
      (searchFormValue: SearchFormOutput) => {
        this.loadingFlag=false;
        console.log("success " + searchFormValue);
        console.log("value-> " + JSON.stringify(searchFormValue));
        if (searchFormValue.listExcelMessage.length == 0) {
          this.myHeaderHeight = "100px";
          this.flagNoData=false;
        }else if (searchFormValue.listExcelMessage.length > 10) {
          this.myHeaderHeight = "400px";
          this.flagNoData=true;
        } else {
          this.myHeaderHeight = null;
          this.flagNoData=true;

        }
        this.dateModifiedExcelList = this.editDateFormat(searchFormValue.listExcelMessage);
        console.log("Excel List-->"+this.dateModifiedExcelList);
        this.rowData = this.dateModifiedExcelList;
      },
      (error: any) => {
        console.log("error ");
      },
      () => {
        console.log("completed ");
      }
    );
  }
  exportAsXLSX():void {
    console.log("------Loading Started----------");
    this.loadingFlag=true;

    this.excelDataArray=[]; //initialize the array
    this.dateModifiedExcelList.forEach(searchForm=>{
      this.excelFormat={
        Sender_ID:searchForm.senderID,
         Transaction_Type:searchForm.transactionType,
         Source:searchForm.source,
         Response_Type:searchForm.responseType,
         Created_By_Id:searchForm.createdById,
         Date:searchForm.dateCellValue,
         Response_Message:searchForm.responseMessage
      };

      console.log("searchForm-->"+JSON.stringify(searchForm));
      //let myData=this.setExcelData(searchForm.senderID,searchForm.transactionType,searchForm.source,searchForm.responseType,searchForm.createdById,searchForm.dateCellValue,searchForm.responseMessage);
      this.excelDataArray.push(this.excelFormat);
    });

    this.excelService.exportAsExcelFile(this.excelDataArray, 'searchList');
    this.loadingFlag=false;
    console.log("------Loading End----------");
  }
  editDateFormat(listExcel: SearchForm[]) {
    let resultList: SearchForm[] = [];
    listExcel.forEach(searchForm => {
       let myDate = searchForm.dateCellValue.split("T")[0];
       searchForm.dateCellValue =myDate+"  "+ searchForm.dateCellValue.split("T")[1].substring(0,8);
      resultList.push(searchForm);
    });
    return resultList;
  }
  formatDates(date: Date): String {
    var d = date;
    let month = "" + (d.getMonth() + 1);
    let day = "" + d.getDate();
    let year = d.getFullYear();

    if (month.length < 2) month = "0" + month;
    if (day.length < 2) day = "0" + day;

    return [year, month, day].join("-");
  }

}
