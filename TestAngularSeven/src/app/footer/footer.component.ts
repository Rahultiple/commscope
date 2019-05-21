import { Component, OnInit, Output } from '@angular/core';
import { EventEmitter } from 'selenium-webdriver';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  @Output() sendData=new EventEmitter();
  sendToParent(textValue:string){
    this.sendData.emit(textValue);
  }

}
