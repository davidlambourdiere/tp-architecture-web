import {Component, OnInit} from "@angular/core";
import {ShutterDTO} from "../../../dto/ShutterDTO";
import {ActivatedRoute, Router} from "@angular/router";
import {ShutterService} from "../../../service/ShutterService";
import {StrapDTO} from "../../../dto/StrapDTO";
import {StrapService} from "../../../service/StrapService";

@Component({
  selector: 'notification/strap',
  templateUrl: './notification.strap.component.html',
  styleUrls: ['./notification.strap.component.scss']
})
export class NotificationStrapComponent implements OnInit{

  id: string;
  strap: StrapDTO;

  constructor(private router: Router, private route: ActivatedRoute, private strapService: StrapService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.findStrap();
}

  findStrap(): void{
    this.route.params.subscribe(params => {
      this.strapService.findStrap(this.id).subscribe(data => {
        this.strap = data;
      })
    })
  }
}
