import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  @Input() public toChildString:String;
  constructor() { }

  ngOnInit() {
        console.log("Parent data is => "+this.toChildString);
  }

}
