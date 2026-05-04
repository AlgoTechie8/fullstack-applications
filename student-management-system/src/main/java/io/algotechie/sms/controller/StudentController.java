package io.algotechie.sms.controller;

import io.algotechie.sms.dto.StudentDto;
import io.algotechie.sms.service.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * <p> This handler method to handle list of students request </p>
     * @return String
     */
    // handler method to handle list of students request
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        log.info("Inside Controller getAllStudents()");
        List<StudentDto> students = studentService.getAllStudents();
        log.info("Students size: {}", students.size());
        model.addAttribute("students", students);
        return "students";
    }

}
