package com.cjc.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@RestController
@RequestMapping("/api")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	HomeService hs;

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student student) 
	{
		logger.info("in AddStudent service....");

		Student stu = hs.addStudent(student);

		if (stu != null) {

			return new ResponseEntity<String>("Student Data Got Added.", HttpStatus.OK);
		}

		else {

			return new ResponseEntity<String>("Student Data is not Added.", HttpStatus.NOT_MODIFIED);
		}

	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudentlist() {

		logger.info("In findAll Method...!");

		List<Student> stulist = hs.findAllStudents();

		if (stulist != null && !stulist.isEmpty()) {
			logger.info("stulist	:" + stulist);
			return new ResponseEntity<List<Student>>(stulist, HttpStatus.OK);
		}

		else {
			logger.info("stulist	:" + stulist);
			return new ResponseEntity<List<Student>>(stulist, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/deleteStu/{uid}")
	public ResponseEntity<String> deletestudentdata(@PathVariable int uid) {
		hs.deletestudent(uid);
		int s=uid;
		if(s>0)
		{
			return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Data is not present", HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(value = "/FetchSingleStu/{uid}", method = RequestMethod.GET)
	public ResponseEntity<Student> fetchsinglestu(@PathVariable int uid) {
		Student stu = hs.fetchsinglestu(uid);

		if (stu != null) {
			logger.info("stu	:" + stu);
			return new ResponseEntity<Student>(stu, HttpStatus.OK);
		}

		else {
			logger.info("stu	:" + stu);
			return new ResponseEntity<Student>(stu, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/updatedata/{uid}", method = RequestMethod.PUT)
	public ResponseEntity<String> updatedata(@RequestBody Student uid) {
		Student student = hs.updatedata(uid);

		if (student != null) 
		{
			logger.info("stu	:" + student);

			return new ResponseEntity<String>("Data updated Succesfully", HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Data is not updated", HttpStatus.NOT_FOUND);
		}
	}
}
