import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail-input',
  templateUrl: './detail-input.component.html',
  styleUrls: ['./detail-input.component.css']
})
export class DetailInputComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  sendBack(){
    location.href="products";
  }
}
