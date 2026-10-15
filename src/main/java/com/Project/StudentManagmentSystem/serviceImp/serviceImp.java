package com.Project.StudentManagmentSystem.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.StudentManagmentSystem.entity.Student;
import com.Project.StudentManagmentSystem.repository.Studentrepository;
import com.Project.StudentManagmentSystem.service.Studentservice;
@Service
public class serviceImp implements Studentservice {
    @Autowired
	  Studentrepository studentrepository;
	@Override
	public List<Student> getAllStudent() {
	
		return studentrepository.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		
		return studentrepository.save(student);
	}
	
	@Override
	public  Student getById(int id) {
		return studentrepository.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		studentrepository.deleteById(id);
		
	}

}
