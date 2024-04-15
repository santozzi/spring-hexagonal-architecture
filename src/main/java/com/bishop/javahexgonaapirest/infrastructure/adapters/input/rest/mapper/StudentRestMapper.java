package com.bishop.javahexgonaapirest.infrastructure.adapters.input.rest.mapper;

import com.bishop.javahexgonaapirest.domain.model.Student;
import com.bishop.javahexgonaapirest.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.bishop.javahexgonaapirest.infrastructure.adapters.input.rest.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {
    Student toStudent(StudentCreateRequest request);
    StudentResponse toStudentResponse(Student student);
    List<StudentResponse> toStudentResponseList(List<Student> studentList);
}
