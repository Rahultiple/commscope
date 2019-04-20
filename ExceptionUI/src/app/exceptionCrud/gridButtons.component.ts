import {Component} from "@angular/core";
import {ICellRendererAngularComp} from "ag-grid-angular";
import { ExceptionCrudService } from '../exceptionCrudService/exception-crud.service';
import { ExcelGridOutput } from '../interface';


@Component({
    selector: 'child-cell',
    template: `<span><button style="height: 20px" (click)="invokeParentUpdateMethod()" class="btn btn-info mr-2" data-target="#myModal" >Edit</button></span>
    <span><button style="height: 20px" (click)="invokeParentDeleteMethod()" class="btn btn-info mr-2" [attr.disabled]="flagButtonDisable">Delete</button></span>`,
    styles: [
        `.btn {
            line-height: 0.5
        }`
    ]
})
export class GridButtonsComponent implements ICellRendererAngularComp {
    public params: any;
   // addModalFlag:boolean=true;
   flagButtonDisable:boolean=null;
   constructor(private auditService: ExceptionCrudService){

    }
    agInit(params: any): void {
        this.params = params;
        console.log("->"+this.params.colDef);
        console.log("=>"+this.params.data);
        console.log("***->"+this.params.node);
        let data:ExcelGridOutput=this.params.data;
        if(data.level=="HIGH"){
          this.flagButtonDisable=true;
        }
    }
    //@Output() childEvent = new EventEmitter();
    public invokeParentUpdateMethod() {
     // this.addModalFlag=false;
        //console.log("Row: ${this.params.node.rowIndex}: -"+this.params.node.rowIndex+" collIndex:: "+this.params.colDef.headerName );
        //this.params.context.componentParent.methodFromParent(`Row: ${this.params.node.rowIndex}, Col: ${this.params.colDef.headerName}`)
        this.auditService.publishUpdateRow('call-update',this.params);
            /*
              search for the  call-update string in exceptionCrud.component.ts  ; it invokes the editRecord method.
            */

      }
    public invokeParentDeleteMethod(){
        console.log("Row Index:- "+this.params.node.rowIndex);
        this.auditService.publishObject("call-addRow",this.params)
         /*
              search for the  call-addRow string in exceptionCrud.component.ts  ; it invokes the deleteRecord  method.
            */
    }
    refresh(): boolean {
        return false;
    }
}
