package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.Student;

public interface HomeService {

	public List<Student> findAllStudents();

	public Student addStudent(Student student);

	public void deletestudent(int uid);

	public Student fetchsinglestu(int uid);

	public Student updatedata(Student uid);

	

	
}
