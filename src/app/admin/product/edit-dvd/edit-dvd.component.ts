import { HttpclientService } from './../../../service/httpclient.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-dvd',
  templateUrl: './edit-dvd.component.html',
  styleUrls: ['./edit-dvd.component.css']
})
export class EditDvdComponent implements OnInit {
  private id: number;
  private dvd;
  private cat;
  constructor(private route: Router, private activatedRoute: ActivatedRoute, private httpClientService: HttpclientService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(parametarMap => {
      this.id = +parametarMap.get('id');
      console.log('edit component...: ' + this.id);
    });
    this.httpClientService
      .getAllCat()
      .subscribe(response => (this.cat = Object.values(response)));


    this.getDvd(this.id);
  }

  // this.httpClientService
  //     .getAllCat()
  //     .subscribe(response => (this.cat = Object.values(response)));
  // }
  getDvd(id) {
    this.httpClientService.getDvdById(id).subscribe(data => {
      console.log("object...: " + data);
      this.dvd = data;
    });
  }
  submit(f) {
    console.log("submit form ...:" + f.id);
    this.httpClientService.editDvd(f, f.id);
    this.route.navigate(['/productadmin']);
  }

}
