package com.ltp.gradesubmission;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
			new Student("Harray Potter", LocalDate.parse("1980-09-29")),
			new Student("Bobby Flay", LocalDate.parse("1980-06-09")),
			new Student("Jimmy Neutron", LocalDate.parse("1980-09-29")),
			new Student("Gordon Ramsay ", LocalDate.parse("1980-09-29"))
		};
		for(Student s : students) {
			studentRepository.save(s);
		}

	}

}
