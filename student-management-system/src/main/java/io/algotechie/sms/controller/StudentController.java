package io.algotechie.sms.controller;

import io.algotechie.sms.dto.StudentDto;
import io.algotechie.sms.service.StudentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
     * @param model
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

    /**
     * <p> This handler method to handle new student request </p>
     * @param model
     * @return String
     */

    // handler method to handle new student request
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        log.info("Inside Controller newStudent()");
        // Student Model object to store student from data
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create-student";
    }
    /**
     * <p> This handler method to handle create new student form request </p>
     * @param studentDto, bindingResult, model
     * @return String
     */
    // handler method to handle create new student form request
    @PostMapping("/students")
    public String createStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult bindingResult, Model model) {
        log.info("Inside Controller createStudent()");
        if (bindingResult.hasErrors()) {
            log.error("BindingResult errors: " + bindingResult.getAllErrors());
            model.addAttribute("student", studentDto);
            return "create-student";
        }
        studentService.createStudent(studentDto);
        log.info("Student successfully created");
        return "redirect:/students";
    }

    /**
     * <p> This handler method to handle edit student request </p>
     * @param studentId, model
     * @return String
     */
    // handler method to handle edit student
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        log.info("Inside Controller editStudent()");
        StudentDto student = studentService.findStudentById(studentId);
        log.info("student: {}",student);
        model.addAttribute("student", student);
        return "edit-student";
    }

    /**
     * <p> This handler method to handle update student form request </p>
     * @param studentId, studentDto, bindingResult, model
     * @return String
     */
    // handler method to handle update student from request
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult bindingResult, Model model){
        log.info("Inside Controller updateStudent() studentId: {}",studentId);
        if(bindingResult.hasErrors()){
            log.error("BindingResult errors: " + bindingResult.getAllErrors());
            model.addAttribute("student", studentDto);
            return "edit-student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        log.info("Student successfully updated");
        return "redirect:/students";
    }
    /**
     *  <p> This handler method to handle delete student request</p>
     * @param studentId
     * @return String
     */
    // handler method to handle delete student request
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        log.info("Inside Controller deleteStudent()");
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
    /**
     * <p> This handler method to handle view student request </p>
     * @param studentId, model
     * @return String
     */
    // handler method to handle view request
    @GetMapping("/students/{studentId}/view")
    public String viewStudentDetails(@PathVariable("studentId")  Long studentId, Model model){
        log.info("Inside Controller viewStudentDetails() studentId: {}",studentId);
        StudentDto student = studentService.findStudentById(studentId);
        model.addAttribute("student", student);
        return "view-student-details";
    }
}
