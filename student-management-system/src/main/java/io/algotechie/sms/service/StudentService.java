package io.algotechie.sms.service;

import io.algotechie.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
}
