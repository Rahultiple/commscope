import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Audit-UI';
  myParentData:string;
  parentString:String="heloFromParent";
  showData(){
    alert("value =>"+this.myParentData);
  }
}
