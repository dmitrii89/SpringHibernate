package com.spring.hibernate.mvc.models;

import com.spring.hibernate.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "Please, provide first name")
    @Size(min=3, message = "Minimum 3 symbols")
    private String firstName;

    @NotNull(message = "Please, provide last name")
    @Size(min=3, message = "Minimum 3 symbols")
    private String lastName;

    @Min(value = 0, message = "Number should be grater or equal than zero")
    @Max(value = 10, message = "Number should be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 digits or chars")
    private String postalCode;

    @CourseCode(value = {"TOP", "LUV"}, message = "Must start with TOP or LUV")
    private String courseCode;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
