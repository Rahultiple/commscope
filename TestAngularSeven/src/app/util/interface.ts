export interface Inteface1{
     id:Number;
     userId:number;
     title:String;
}
export interface SearchForm{
  senderID:Number;
  transactionType:String;
  responseType:String;
  createdById:String;
  dateCellValue:String;
  responseMessage:String;
  source:String;
}
export interface Params {
  page?: number
}
export interface SearchFormOutput{
  statusCode:Number;
  statusMSG:String;
  listExcelMessage:SearchForm[]
}
