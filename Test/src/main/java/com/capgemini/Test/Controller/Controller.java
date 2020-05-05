package com.capgemini.Test.Controller;

import java.math.BigInteger;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.Test.Service.ServiceClass;
import com.capgemini.Test.entity.Test;


@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")
public class Controller {

	@Autowired
	private ServiceClass service;
	
	@PostMapping("/addTest")
	public ResponseEntity<String> AddTest(@RequestBody Test test) {
		Test u = service.addTest(test);
		if (u == null) {

			return new ResponseEntity<String>("Test not added", new HttpHeaders(), HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Test added successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@GetMapping("/testdetails")
	public List<Test> TestDetails(){
		List<Test> u=service.testDetails();
		
		return u;
	}
	
	
	
	@PutMapping("/updateTest")
	public ResponseEntity<String> UpdateTest(@RequestBody Test test) {
		Test t = service.updateTest(test);
		if (t == null) {
			
			return new ResponseEntity<String>("Update Operation Unsuccessful,Provided testId does not exist", new HttpHeaders(), HttpStatus.OK);
		
		} else {
			return new ResponseEntity<String>("Test updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@DeleteMapping("/deleteTest/{id}")
	public ResponseEntity<String> DeleteTest(@PathVariable("id") BigInteger id) {
		String u = service.deleteTest(id);
		if (u == null) {
			return new ResponseEntity<String>("Delete operation is unsuccessful", new HttpHeaders(), HttpStatus.OK);
			
		
		} else {
			return new ResponseEntity<String>("Delete operation is successful", new HttpHeaders(), HttpStatus.OK);
		}
	}
}
