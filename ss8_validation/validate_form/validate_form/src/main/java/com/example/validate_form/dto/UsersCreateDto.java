package com.example.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UsersCreateDto implements Validator {
    @Size(min = 5, message = "độ dài tối thiểu là 5")
    @Size(max = 45, message = "độ dài tối đa là 45")
    private String firstName;
    @Size(min = 5, message = "độ dài tối thiểu là 5")
    @Size(max = 45, message = "độ dài tối đa là 45")
    private String lastName;
    @Pattern(regexp = "^\\d{10,12}$", message = "sđt phải nhập 10-12 kí tự số")
    private String phoneNumber;
    @Min(value = 18, message = "tuổi phải lớn hơn hoặc bằng 18")
    private int age;
    @Email
    private String email;

    public UsersCreateDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UsersCreateDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
