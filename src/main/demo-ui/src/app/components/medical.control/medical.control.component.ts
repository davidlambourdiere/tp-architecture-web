import {Component} from "@angular/core";
import {PersonDTO} from "../../dto/PersonDTO";
import {PersonService} from "../../service/PersonService";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../service/AuthService";
declare  var jQuery:  any;
@Component({
  selector: 'medicalControl',
  templateUrl: './medical.control.component.html',
  styleUrls: ['./medical.control.component.scss']
})
export class MedicalControlComponent {
  person: PersonDTO;
  constructor(private personService: PersonService, private router: Router, private route: ActivatedRoute, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.person = JSON.parse(localStorage.getItem('user'));
    // @ts-ignore
    (function($) {

      "use strict";

      var fullHeight = function() {

        $('.js-fullheight').css('height', $(window).height());
        $(window).resize(function(){
          $('.js-fullheight').css('height', $(window).height());
        });

      };
      fullHeight();

      $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
      });

    })(jQuery);

  }


}
