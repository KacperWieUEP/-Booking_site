package com.uep.wap.controller;

import com.uep.wap.dto.StudentDTO;
import com.uep.wap.dto.StudentsDataDTO;
import com.uep.wap.model.Student;
import com.uep.wap.service.StudentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class StudentController {

    private final StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping(path = "/hello")
    public String sayHello(){
        return "Hello!";
    }

    @GetMapping(path = "/students")
    public Iterable<Student> getAllStudents(){
        return studentsService.getAllStudents();
    }

    @PostMapping(path = "/students")
    public String addStudents(@RequestBody StudentDTO studentDTO){
        studentsService.addStudent(studentDTO);
        return "Students added!";
    }

}
