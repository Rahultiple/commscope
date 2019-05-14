package com.commscope.bu.controller;

import com.commscope.bu.model.APartyDetails;
import com.commscope.bu.model.DocDates;
import com.commscope.bu.model.Header;
import com.commscope.bu.model.POAckInputJsonObject;
import com.commscope.bu.model.Student2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/test/")
public class BuisinessAPIController {
	
		
  /*  @RequestMapping(value = "/students", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Student2 createNewStudent(@RequestBody @Valid Student student) {
    	Student saveStudent = studentService.saveStudent(student);
    
    	HashMap<String, String> hashMap = new HashMap<String,String>();
    	hashMap.put("class", saveStudent.getGrade());
    	hashMap.put("gender", saveStudent.getGender());
    	hashMap.put("name", saveStudent.getName());
    	//saveStudent.setStudentMap(hashMap);
    	Student2 student2 = new Student2(hashMap);
    	return student2;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Long id) {
         return studentService.getStudentDetails(id);
    }
    
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable Long id) {
        
    }*/
		private static Validator validator;
		
		@RequestMapping(value = "/poAck", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.OK)
	    public Student2 getPOAck(@Valid @RequestBody POAckInputJsonObject student) {
		 	
		 	System.out.println("Student :"+student);
		 	
		 	Header header = student.getHeader();
		 	System.out.println("HeaderClass :"+header);
		 	
		 	
		 	
		 	System.out.println("partyDetsilas :"+header.getAPartyDetails());
		 	System.out.println("partyDetsilas :"+header.getCType());
		 	System.out.println("partyDetsilas :"+header.getDocDates());
		 	
		 	
		 	//Start Experiment 
		 	

		 	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		    validator = factory.getValidator();
		    Set<ConstraintViolation<APartyDetails>> constraintViolations = validator.validate(header.getAPartyDetails());
		    
		    for(ConstraintViolation<APartyDetails> constraint :constraintViolations ) {
		    	System.out.println("=>"+constraint.getMessage());
		    	System.out.println("=>"+constraint.getInvalidValue());
		    	System.out.println("=>"+constraint);
		    	System.out.println("=>"+constraint.getInvalidValue());
		    }
		    
		 	//End Experiment
		 	
		 	HashMap<String, Object> studentMap = new HashMap<String,Object>();
		 	LinkedHashMap<String, Object> headerMap = new LinkedHashMap<String,Object>();
		 	
		 	LinkedHashMap<String, Object> aPartyDetailsMap = new LinkedHashMap<String,Object>();
		 	aPartyDetailsMap.put("Sender", "CompanyA");
		 	aPartyDetailsMap.put("Receiver", "Commscope");
		 	
		 	LinkedHashMap<String, Object> cTypeMap = new LinkedHashMap<String,Object>();
		 	cTypeMap.put("Doctype", "orders");
		 	cTypeMap.put("Vertype", "1");
		 	cTypeMap.put("SEmail", "supportEmail@email.com");
		 	
		 	headerMap.put("APartyDetails",aPartyDetailsMap);
		 	headerMap.put("CType",cTypeMap);
		 	headerMap.put("DocDates",new DocDates());
		 	studentMap.put("Header", headerMap);
		 	Student2 st= new Student2(studentMap);
		 	
		 	return st;
	    }
	 
	 	@GetMapping(value = "/helloFromWebApp")
		public String hello() {
			 return "Hello World from Azure Web App API";
		}
	 	
	 	@RequestMapping(value = "/epi", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.OK)
	    public Student2 processEPI(@RequestBody String student,HttpServletRequest request) {
		 	
		 	System.out.println("Student :"+student);
		 	System.out.println("Header :"+request.getHeader("Filename"));
		
		 	HashMap<String, Object> studentMap = new HashMap<String,Object>();
		 	LinkedHashMap<String, Object> headerMap = new LinkedHashMap<String,Object>();
		 	
		 	LinkedHashMap<String, Object> aPartyDetailsMap = new LinkedHashMap<String,Object>();
		 	aPartyDetailsMap.put("Sender", "CompanyA");
		 	aPartyDetailsMap.put("Receiver", "Commscope");
		 	
		 	LinkedHashMap<String, Object> cTypeMap = new LinkedHashMap<String,Object>();
		 	cTypeMap.put("Doctype", "orders");
		 	cTypeMap.put("Vertype", "1");
		 	cTypeMap.put("SEmail", "supportEmail@email.com");
		 	
		 	headerMap.put("APartyDetails",aPartyDetailsMap);
		 	headerMap.put("CType",cTypeMap);
		 	headerMap.put("DocDates",new DocDates());
		 	studentMap.put("Header", headerMap);
		 	Student2 st= new Student2(studentMap);
		 	
		 	return st;
	    }
	 
}
