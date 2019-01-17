package com.spring.hibernate.mvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    @NotNull(message = "Please, provide first name")
    @Size(min=3, message = "Minimum 3 symbols")
    private String firstName;

    @NotNull(message = "Please, provide last name")
    @Size(min=3, message = "Minimum 3 symbols")
    private String lastName;

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
}
