package com.cjc.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	private static final Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	@Autowired
	HomeRepository hr;

	@Override
	public List<Student> findAllStudents() {

		logger.info("In service findAllStudent() Method");
		
		List<Student> stulist =  (List<Student>) hr.findAll();
		if(stulist!=null && !stulist.isEmpty())
		{
			logger.info("stulist"+stulist);
			return stulist;
		}
		else
		{
			logger.info("stulist"+ new ArrayList<Student>());
			return new ArrayList<Student>();
		}
	}

	@Override
	public Student addStudent(Student student) {

		logger.info("In service AddStudent() Method");
		
		Student student1 =hr.save(student);		
		return student1;
	}

	@Override
	public void deletestudent(int uid) {
		
		 hr.deleteById(uid);
		
	}

	@Override
	public Student fetchsinglestu(int uid) {

		//return hr.findAllById(uid);
		return hr.findAllByUid(uid);
	}

	@Override
	public Student updatedata(Student uid) {
		
		Student student = hr.save(uid);
		
		return student;
	}

}
