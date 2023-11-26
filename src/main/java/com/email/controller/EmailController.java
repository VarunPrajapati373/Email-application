package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/welcome")
	public String Welcome() {
		
		return "Hello this is my email API";
	}
	
	//API to send mail
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		boolean status= this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		
		if(status) {
	
			return ResponseEntity.ok("Email sent successfully");
			
		}else {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Opps error occured");
			
		}
		
	}

}
