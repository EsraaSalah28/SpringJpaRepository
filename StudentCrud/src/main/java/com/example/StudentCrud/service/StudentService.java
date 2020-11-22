package com.example.StudentCrud.service;

import java.util.List;

import com.example.StudentCrud.domain.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theStudent);

	public void deleteById(int theId);
}
