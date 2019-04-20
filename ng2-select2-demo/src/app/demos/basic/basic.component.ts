import { Component, OnInit } from '@angular/core';
import { Select2OptionData } from 'ng2-select2';

@Component({
  selector: 'app-basic',
  templateUrl: './basic.component.html',
  styleUrls: ['./basic.component.css']
})
export class BasicComponent implements OnInit {
  public exampleData: Array<Select2OptionData>;
  
  
  testingData:string;
  startValue:string="tiple";
  ngOnInit() {
    this.exampleData = [
      {
        id: 'basic1',
        text: 'rahul',
       },
      {
        id: 'basic2',
        disabled: true,
        text: 'tiple'
      },
      {
        id: 'basic3',
        text: 'suhas'
      },
      {
        id: 'basic4',
        text: 'Sony'
      }
    ];
 
  }

 callChange(e:any){
    console.log("Data:: "+e);
      console.log("Data:: "+e.element); 
       // console.log("Data:: "+e.element.text); 
    this.testingData = e.value;
    alert("322343-> "+this.testingData);
 }

}

