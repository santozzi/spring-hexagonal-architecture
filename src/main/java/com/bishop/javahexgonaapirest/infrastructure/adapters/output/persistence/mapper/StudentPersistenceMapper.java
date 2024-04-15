package com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence.mapper;
import com.bishop.javahexgonaapirest.domain.model.Student;
import com.bishop.javahexgonaapirest.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {
    //para especificar si tuvieran distinto nombre los atributos
    // @Mapping(target ="ege" , source= "edad")
    StudentEntity toStudentEntity(Student student);
    Student toStudent (StudentEntity entity);

    List<Student> toStudentList(List<StudentEntity> entityList);
    List<StudentEntity> toStudentEntityList (List<Student> sudentList);
}
