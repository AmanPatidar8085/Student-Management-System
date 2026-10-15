package com.Project.StudentManagmentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Project.StudentManagmentSystem.entity.Student;
import com.Project.StudentManagmentSystem.service.Studentservice;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private Studentservice service;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudent());
		return "students";
	}

	@GetMapping("students/new")
	public String createStudentFrom(Model model) {
		Student student = new Student();
		model.addAttribute("students", student);
		return "create-student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
	service.saveStudent(student);
	return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentFrom(@PathVariable int id,Model model) {
		model.addAttribute("student", service.getById(id));
		return "edit_student";
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student")Student student) {
		Student existingStudent=service.getById(id);
		existingStudent.setFirst_name(student.getFirst_name());
		existingStudent.setLast_name(student.getLast_name());
		existingStudent.setEmail(student.getEmail());
		
		service.saveStudent(existingStudent);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";
	}

}
