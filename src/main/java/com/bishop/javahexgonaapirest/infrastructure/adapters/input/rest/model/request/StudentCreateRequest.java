package com.bishop.javahexgonaapirest.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank(message = "Field firstname cannot be empty or null")
    private String firstName;
    @NotBlank(message = "Field lastname cannot be empty or null")
    private String lastName;
    @NotNull(message = "Field age cannot be empty or null")
    private int age;
    @NotBlank(message = "Field firstname cannot be empty or null")
    private String address;

}
