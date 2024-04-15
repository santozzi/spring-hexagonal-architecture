package com.bishop.javahexgonaapirest.application.ports.output;

import com.bishop.javahexgonaapirest.domain.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save (Student student);

    void deleteById(Long id);
}
