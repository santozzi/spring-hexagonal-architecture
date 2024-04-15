package com.bishop.javahexgonaapirest.application.service;

import com.bishop.javahexgonaapirest.application.ports.input.StudentServicePort;
import com.bishop.javahexgonaapirest.application.ports.output.StudentPersistencePort;
import com.bishop.javahexgonaapirest.domain.exception.StudentNotFoundException;
import com.bishop.javahexgonaapirest.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort persistencePort;
    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
        //.orElseThrow(StudentNotFoundException::new) es igual a
        //.orElseThrow(()->StudentNotFoundException())
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student estudianteEncontrado = persistencePort.findById(id).orElseThrow(StudentNotFoundException::new);
        estudianteEncontrado.setFirstName(student.getFirstName());
        estudianteEncontrado.setAge(student.getAge());
        estudianteEncontrado.setLastName(student.getLastName());
        estudianteEncontrado.setAddress(student.getAddress());
        return persistencePort.save(estudianteEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        if (persistencePort.findById(id).isEmpty()){
            throw new StudentNotFoundException();
        }
        persistencePort.deleteById(id);
    }
}
