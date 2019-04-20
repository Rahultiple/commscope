import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bidding',
  templateUrl: './bidding.component.html',
  styleUrls: ['./bidding.component.css']
})
export class BiddingComponent implements OnInit {
  color:String="red";
  constructor() { }

  ngOnInit() {

    jQuery('#action_menu_btn').click(function(){
      jQuery('.action_menu').toggle();
    });

  }
  sendBack(){
    location.href="products";
  }
}
