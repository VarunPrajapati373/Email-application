import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from 'src/app/service/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent {

  data={
    to:"",
    subject:"",
    message:""
  }

  constructor(private email:EmailService, private snack:MatSnackBar){

  }

  doSubmitForm(){
    console.log("try to submit form");
    console.log("DATA",this.data);

    if(this.data.to=='' || this.data.subject=='' || this.data.message==''){

      this.snack.open("Field are empty, please check","OK");
      return;

    }

    this.email.sendEmail(this.data).subscribe(

      response=>{

        console.log(response);
   
      },
      error=>{

        console.log(error);
        
      }

    )
  }


}
