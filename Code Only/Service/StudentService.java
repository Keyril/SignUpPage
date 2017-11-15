package com.app.crud.Service;

import com.app.crud.Entity.Student;
import com.app.crud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Collection<Student> getAllStudents(){
        return studentRepository.get(0,100);
    }

    public Student getStudentById(int id){
        return this.studentRepository.get(id);
    }


    public void removeStudentById(int id) {
        this.studentRepository.remove(this.studentRepository.get(id));

    }

    public void createStudent(String firstName,String lastName,String gender,String course){
        int randomNum = ThreadLocalRandom.current().nextInt(10, 999);
        Student newStudent = new Student(randomNum, firstName, lastName, course, gender);
        this.studentRepository.save(newStudent);
    }

}
