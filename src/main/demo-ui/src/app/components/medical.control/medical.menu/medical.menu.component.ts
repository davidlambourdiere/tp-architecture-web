import { Component, OnInit } from '@angular/core';
import {PersonDTO} from "../../../dto/PersonDTO";
import {PersonService} from "../../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../../service/AuthService";
import {AlertHealthService} from "../../../service/AlertHealthService";
declare  var jQuery:  any;

@Component({
  selector: 'app-medicalmenu',
  templateUrl: './medical.menu.component.html',
  styleUrls: ['./medical.menu.component.scss']
})
export class MedicalMenuComponent implements OnInit {

  person: PersonDTO;
  newAlertsNumber: Number;
  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private alertHealthService: AlertHealthService) {
    this.newAlertsNumber=0;
  }

  ngOnInit(): void {
    this.person = JSON.parse(localStorage.getItem('user'));
    // @ts-ignore
    (function ($) {

      "use strict";

      var fullHeight = function () {

        $('.js-fullheight').css('height', $(window).height());
        $(window).resize(function () {
          $('.js-fullheight').css('height', $(window).height());
        });

      };
      fullHeight();

      $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
      });

    })(jQuery);
    this.findNewAlertsNumber();
  }

  private findNewAlertsNumber() {
//alertNumber
    this.route.params.subscribe(params =>{
      this.alertHealthService.findAlertNumber().subscribe(data=>{
        this.newAlertsNumber = data;
      });
    });
  }
}
