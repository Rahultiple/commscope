import { Observable, Subscription } from 'rxjs';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {  FormGroup,FormControl } from '@angular/forms';
import { ExceptionCrudService } from '../exceptionCrudService/exception-crud.service';
import { ExcelFormat,ExcelReadServiceInterface,Params,ExceptionData,ResponseData,ExcelGridOutput } from '../interface';
import { formatDate, DatePipe } from "@angular/common";
import { ExcelServiceService } from '../exceptionCrudService/excel-service.service'
import { GridButtonsComponent } from './gridButtons.component';
import {GridOptions} from "ag-grid-community";

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
  templateUrl: "./exceptionCrud.component.html",
  styleUrls: ["./exceptionCrud.component.css"],
})
export class ExceptionCrudComponent implements OnInit {
  private gridApi;
  private rowSelection;
  inputGridData:ExcelGridOutput;
  public gridOptions: GridOptions;
 // addModalFlag:boolean=true;
  modalHeader:string;
  responseType1: String;
  fromDate: Date;
  searchForm: FormGroup;
  showGrid: boolean = false;
  myHeaderHeight: String;
  excelList:ExcelGridOutput[];
  excelDataArray:ExcelFormat[]=[];
  excelFormat:ExcelFormat;
  errorObject:ExcelGridOutput;
  loadingFlag:boolean=false;
  flagNoData: boolean = true;
  closeResult: string;
  @ViewChild('modelContent') modelContent: ElementRef;
  columnDefs = [
    { headerName: "Error Code", field: "internalErrorCode" },
    { headerName: "Error Type", field: "errorType" },
    { headerName: "Exception Message", field: "exceptionMessage" ,  width: 300},
    { headerName: "Level", field: "level" },
    {
      headerName: "Action",
      field: "value",
      cellRendererFramework: GridButtonsComponent,
      colId: "params",
      width: 180
   }
  ];
  rowData: any;
  pipe: DatePipe; // Use your own locale
  subscription:Subscription;
  constructor(private auditService: ExceptionCrudService,private excelService:ExcelServiceService,private modalService: NgbModal) {
    this.rowSelection = "single";
    this.gridOptions = <GridOptions>{
                        context: {
                          componentParent: this
                        }
                    };
  }
  ngOnInit() {
    this.loadingFlag=true;
    this.showGrid = true;
    this.onSubmit();
    this.subscription = this.auditService.receiveObject('call-update').subscribe((param:any) => this.editRecord(param));
    this.subscription = this.auditService.receiveObject("call-addRow").subscribe((param:any)=>this.deleteRecord(param));
  }
  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  onSubmit() {
    this.loadingFlag=true;
    this.showGrid = true;
    let observableService: Observable<ExcelReadServiceInterface>= this.auditService.callAuditSearch();
    observableService.subscribe(
      (serviceResponse: ExcelReadServiceInterface) => {
        console.log(JSON.stringify(serviceResponse.data.exceptionData.response.errorCodeList));
        this.excelList=serviceResponse.data.exceptionData.response.errorCodeList;
        this.loadingFlag=false;
        console.log("success " + serviceResponse.status);
        console.log("value-> " + JSON.stringify(this.excelList));
        if (this.excelList.length == 0) {
          this.myHeaderHeight = "100px";
          this.flagNoData=false;
        }else if (this.excelList.length > 10) {
          this.myHeaderHeight = "300px";
          this.flagNoData=true;
        } else {
          this.myHeaderHeight = null;
          this.flagNoData=true;

        }
        this.rowData = this.excelList;
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
    this.excelList.forEach(errorObject=>{
      this.excelFormat={
         Internal_Error_Code:errorObject.internalErrorCode,
         Error_Type:errorObject.errorType,
         Exception_Message:errorObject.exceptionMessage,
         Level:errorObject.level
      };

      console.log("searchForm-->"+JSON.stringify(errorObject));
      //let myData=this.setExcelData(searchForm.senderID,searchForm.transactionType,searchForm.source,searchForm.responseType,searchForm.createdById,searchForm.dateCellValue,searchForm.responseMessage);
      this.excelDataArray.push(this.excelFormat);
    });

    this.excelService.exportAsExcelFile(this.excelDataArray, 'errorCodeList');
    this.loadingFlag=false;
    console.log("------Loading End----------");
  }


  onSelectionChanged(event) {
    console.log("row selected "+event);
    var selectedRows = this.gridApi.getSelectedRows();

    var selectedRowsString = "";
    selectedRows.forEach(excelGridOutput=>{
      document.querySelector("#selectedRows").innerHTML =excelGridOutput.exceptionMessage;
    });
    // selectedRowsString;
  }
  onGridReady(params) {
    console.log("Params->"+params)
    this.gridApi = params.api;
   // this.gridColumnApi = params.columnApi;

  }
  editRecord(params){
   // this.addModalFlag=false;
     this.modalHeader="Edit Row";
    console.log("Row Index--> "+params.node.rowIndex+" Header Name:- "+params.colDef.headerName);
   // alert(" inside the parent ");
    console.log("-->"+this.modelContent.nativeElement);
    //this.modelContent.nativeElement.modelContent=false;
    let rowObject:ExcelGridOutput =  this.getJSONObject(this.excelList, params.node.rowIndex);
   // alert("rowObject Object "+JSON.stringify(rowObject));
    this.inputGridData=rowObject;
    this.openModel(this.modelContent);

  }
  public deleteRecord(params) {
    let successFulExecution=false;
    console.log("Row Index--> "+params.node.rowIndex+" Header Name:- "+params.colDef.headerName);
     successFulExecution=true;
     let excelObject:ExcelGridOutput =  this.getJSONObject(this.excelList, params.node.rowIndex);
   //  alert("Excel Object "+JSON.stringify(excelObject));
     this.auditService.callDeleteRow(excelObject.internalErrorCode+"").subscribe((response:any)=>{
      console.log("Row Deleted:-"+response.data.exceptionData.response.isRowDeleted);
      alert("Row Deleted Successfully");
     },
     (error)=>{
        console.log("Error Happened in service "+JSON.stringify(error));
        alert("Error Happened in service "+JSON.stringify(error));
     },
     ()=>{
          if(successFulExecution){
              this.onSubmit();
          }
     });


  }

  getJSONObject(list:ExcelGridOutput[],indexValue):ExcelGridOutput{
     let excelObj:ExcelGridOutput=list[indexValue];
     return excelObj;
  }
  openAddRowModel(modelContent) {
    //this.addModalFlag=true;
    this.modalHeader="Add Row";
    this.openModel(modelContent);
    this.inputGridData=null;
  }
  private openModel(modelContent) {

    console.log("model-content :-"+modelContent);
    this.modalService.open(modelContent, {ariaLabelledBy: 'modal-basic-title',centered: true, size: 'lg'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  private getDismissReason(reason: any): string {
    //alert("11111 =>"+reason);
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      if(reason=="success"){
        this.onSubmit();
      }
      return  `with: ${reason}`;
    }
  }

}
