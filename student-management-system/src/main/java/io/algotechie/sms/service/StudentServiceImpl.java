package io.algotechie.sms.service;

import io.algotechie.sms.dto.StudentDto;
import io.algotechie.sms.entity.Student;
import io.algotechie.sms.mapper.StudentMapper;
import io.algotechie.sms.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl  implements StudentService {
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * <p> This method fetches the all students records</p>
     * @return List<StudentDto>
     */
    @Override
    public List<StudentDto> getAllStudents() {
        log.info("Inside StudentServiceImpl.getAllStudents()");
        List<Student> studentList = studentRepository.findAll();
        log.info("studentList={}", studentList);
        List<StudentDto> studentDtoList = studentList.stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
        log.info("studentDtoList={}", studentDtoList);
        return studentDtoList;
    }
}
