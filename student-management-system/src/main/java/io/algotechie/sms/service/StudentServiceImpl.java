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

    /**
     * <p> This method create the new student record and save into DB</p>
     * @Param studentDto
     * @return Void
     */
    @Override
    public void createStudent(StudentDto studentDto) {
        log.info("Inside StudentServiceImpl.createStudent()");
        Student student = StudentMapper.mapToStudent(studentDto);
        log.info("student={}", student);
        studentRepository.save(student);
    }

    /**
     * <p> This method used to fetch the existing record for edit request</p>
     * @Param studentId
     * @return StudentDto
     */
    @Override
    public StudentDto findStudentById(Long studentId) {
        log.info("Inside StudentServiceImpl.findStudentById() {}",studentId);
        Student student = studentRepository.findById(studentId).get();
        log.info("student={}", student);
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    /**
     * <p> This method update the existing record</p>
     * @Param studentDto
     * @return Void
     */
    @Override
    public void updateStudent(StudentDto studentDto) {
        log.info("Inside StudentServiceImpl.updateStudent() {}",studentDto);
        studentRepository.save(StudentMapper.mapToStudent(studentDto));
        log.info("Student successfully updated ");
    }
}
