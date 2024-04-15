package com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence;

import com.bishop.javahexgonaapirest.application.ports.output.StudentPersistencePort;
import com.bishop.javahexgonaapirest.domain.model.Student;
import com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {
    private final StudentRepository studentRepository;
    private final StudentPersistenceMapper mapper;
    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id)
                .map(mapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return mapper.toStudentList(studentRepository.findAll());
    }

    @Override
    public Student save(Student student) {

        return mapper.toStudent(studentRepository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
