import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import * as $ from 'jquery';
import { HttpClient } from '@angular/common/http';
import { LoginService } from './../../services/login.service';
import { Account } from './../../objects/account';
import { NgForm } from '@angular/forms';
import { NavbarService } from '../../services/navbar.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  // account = Account;
  // account2 = Account;
  @ViewChild('content') content: ElementRef;
  closeResult: string;

  constructor(
    private http: HttpClient,
    private login: LoginService,
    private router: Router,
    private cookieService: CookieService,
    private nav: NavbarService,
    private modalService: NgbModal
  ) {}

  account: Account;

  ngOnInit() {
    this.nav.visible = false;
    this.login.currentAccount.subscribe(account => (this.account = account));

    $(document).ready(function() {
      const panelOne = $('.form-panel.two').scrollHeight,
        panelTwo = $('.form-panel.two')[0].scrollHeight;

      $('.form-panel.two')
        .not('.form-panel.two.active')
        .on('click', function(e) {
          e.preventDefault();

          $('.form-toggle').addClass('visible');
          $('.form-panel.one').addClass('hidden');
          $('.form-panel.two').addClass('active');
          $('.form').animate(
            {
              height: panelTwo
            },
            200
          );
        });

      $('.form-toggle').on('click', function(e) {
        e.preventDefault();
        $(this).removeClass('visible');
        $('.form-panel.one').removeClass('hidden');
        $('.form-panel.two').removeClass('active');
        $('.form').animate(
          {
            height: panelOne
          },
          200
        );
      });
    });
  }

  //acc = new Account('', '', '', '', '', '', null, false, false, false, false);
  regAcc = new Account(
    '',
    '',
    '',
    '',
    '',
    '',
    null,
    false,
    false,
    false,
    false,
    null
  );

  cLogin() {
    this.login.checkLogin(this.account).subscribe(
      data => {
        if (data != null) {
          this.login.changeAccount(data);
          this.cookieService.set('userid', data.accountId);
          this.router.navigate(['item-list']);
          this.nav.visible = true;
        } else {
          console.log('No!');
          this.open(this.content);
        }
      },
      error => {
        console.log('error');
      }
    );
  }

  register(a: Account) {
    this.login.registerService(this.regAcc).subscribe(
      data => {
        if (data != null) {
          this.login.changeAccount(data);
          this.cookieService.set('userid', data.accountId);
          this.router.navigate(['item-list']);
          this.nav.visible = true;
        }
        console.log(data);
      },
      error => {
        console.log('error');
      }
    );
  }

  open(content) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        result => {
          this.closeResult = `Closed with: ${result}`;
        },
        reason => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
}
