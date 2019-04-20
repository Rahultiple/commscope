export interface Inteface1{
     id:Number;
     userId:number;
     title:String;
}
export interface ExcelReadServiceInterface{
  status:string;
  code:number;
  data:ReadExceptionDataResponse;
}
export interface ReadExceptionDataResponse{
  exceptionData:ExceptionData;
}
export interface ExceptionData{
  response:ResponseData;
}
export interface ResponseData{
  errorCodeList: ExcelGridOutput[];
}

export interface Params {
  page?: number
}
export interface ExcelGridOutput{
  internalErrorCode:Number;
  errorType:String;
  exceptionMessage:String;
  level:String;
}
export interface ExcelFormat{
  Internal_Error_Code:Number;
  Error_Type:String;
  Exception_Message:String;
  Level:String;

}
export interface SaveRow{
  Internal_Error_Code:Number;
  Error_Type:String;
  Exception_Message:String;
  Level:String;
}
export interface UpdateRow{
  Internal_Error_Code:Number;
  Error_Type:String;
  Exception_Message:String;
  Level:String;
}
