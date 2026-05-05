package io.algotechie.sms.service;

import io.algotechie.sms.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void createStudent(@Valid StudentDto studentDto);

    StudentDto findStudentById(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);
}
