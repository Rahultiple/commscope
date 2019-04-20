import { Component, OnInit, Input } from '@angular/core';
import {  FormGroup,FormControl, Validators} from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import * as $ from 'jquery';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ExceptionCrudService } from '../exceptionCrudService/exception-crud.service';
import { ExcelGridOutput, ExcelFormat } from '../interface';
import { JsonPipe } from '@angular/common';
@Component({
  selector: 'app-add-excel-row',
  templateUrl: './add-excel-modal-row.component.html',
  styleUrls: ['./add-excel-modal-row.component.css']
})
export class AddExcelRowComponent implements OnInit {
  addForm: FormGroup;
  levelTypes: string[] = ["LOW", "MEDIUM", "HIGH"];
  disabledButton:boolean=true;
  @Input() inputGridData:ExcelGridOutput;
  disabled:boolean=null;
  flagEditForm:boolean=false;
  showModal:boolean=false;
  flagShowError:boolean=false;
  showErrorData:string;
  constructor(private auditService: ExceptionCrudService,private modalService: NgbModal) {
    console.log("--AddExcelRowComponent constructor---- --");
   }

  ngOnInit() {
    this.flagShowError=false;
    console.log("--Add Excel Modal row component ngOnInit --"+this.inputGridData);

    this.addForm = new FormGroup({
        Internal_Error_Code: new FormControl("",[Validators.required,Validators.pattern('[0-9]*')]),
        Error_Type: new FormControl(),
        Level: new FormControl(),
        Exception_Message: new FormControl()

      });
      let valueObj:Observable<ExcelFormat>= this.addForm.valueChanges;
      valueObj.subscribe((textValue:ExcelFormat)=>{
            console.log("value Changed:->"+JSON.stringify(textValue));
            let fg=this.addForm;
            console.log("errors ->"+this.addForm.get("Internal_Error_Code").errors);
            var errorCodeVal=textValue.Internal_Error_Code+"";
            if(( fg.get("Internal_Error_Code").errors ==null) && (fg.get("Error_Type").errors ==null)
            && (fg.get("Exception_Message").errors ==null)) {
              this.disabledButton=null;
            }else{
              this.disabledButton=true
            }
      })
     // this.disabled=false;
    if(this.inputGridData!=null){
      this.addForm.setValue({"Internal_Error_Code":this.inputGridData.internalErrorCode,"Error_Type":this.inputGridData.errorType,
      "Level":this.inputGridData.level,"Exception_Message":this.inputGridData.exceptionMessage
      });
      this.disabled=true
      this.flagEditForm=true;
    };

  }


  onSaveRow(){
    console.log("Submit Form: " + JSON.stringify(this.addForm.value));
    try {
      console.log("-->" + this.addForm.get('Internal_Error_Code').errors);
      console.log("-->" + this.addForm.get('Internal_Error_Code').touched + " --- " + this.addForm.get('Internal_Error_Code').dirty);
      let isButtonDisable = false;
      if (this.addForm.get('Internal_Error_Code').errors != null && this.addForm.get('Internal_Error_Code').errors.required) {

        isButtonDisable = true;
      }
      if (this.addForm.get('Error_Type').errors != null && this.addForm.get('Error_Type').errors.required) {
        isButtonDisable = true;
      }
      if (this.addForm.get('Exception_Message').errors != null && this.addForm.get('Exception_Message').errors.required) {
        isButtonDisable = true;
      }
      if(!isButtonDisable){
        this.disabledButton=null;
      }else{
        this.disabledButton = true;
      }

    } catch (e) {

    }
    this.flagShowError=false;
    let obj:Observable<any>;
    this.showModal=true;
    if(this.flagEditForm){
       obj =  this.auditService.callUpdateRow(this.addForm.value);
    }else{
      //Add function
       obj =  this.auditService.callSaveRow(this.addForm.value);
    }

    obj.subscribe((response)=>{

      console.log("Row Inserted:-"+response.data.exceptionData.response.isRowInserted);
      if(this.flagEditForm){
        alert("Row updated Successfully");
      }else{
        alert("Row inserted Successfully");
      }
      this.showModal=false;
      this.modalService.dismissAll("success");

    },
    (responseError)=>{
      this.showModal=false;
      console.log("Error Happened in service "+JSON.stringify(responseError));
      this.flagShowError=true;
      //alert("Error Happened in service "+JSON.stringify(error));
      this.showErrorData=responseError.error.data.exceptionData.details;
    },
    ()=>{

    });
  }

  closeModal(event:any){
    this.modalService.dismissAll("success");

 }
}
