package com.Project.StudentManagmentSystem.service;

import java.util.List;

import com.Project.StudentManagmentSystem.entity.Student;

public interface Studentservice {

	 public List<Student> getAllStudent();
	 
	 public Student saveStudent(Student student);
	 public Student getById(int id);
	 public void deleteById(int id);
}
