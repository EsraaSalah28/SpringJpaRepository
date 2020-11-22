package com.example.StudentCrud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		Student theStudent = null;
		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			throw new RuntimeException("did not find student id " + theId);

		}
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {

		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {

		studentRepository.deleteById(theId);

	}

}
