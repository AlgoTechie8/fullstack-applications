package io.algotechie.sms.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    @NotEmpty(message = "Student First Name should not empty, Please Enter first Name")
    private String firstName;
    @NotEmpty(message = "Student last name should not empty, please enter last name")
    private String lastName;
    @NotEmpty(message = "Student email should not empty, please enter valid email address")
    @Email
    private String email;
}
