package com.centime.service1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
public class Customer {

    @NotBlank(message = "Name is mandatory")
    @JsonProperty("Name")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    @JsonProperty("Surname")
    private String surname;

    @Override
    public String toString() {
        return "{" +
                "Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                '}';
    }
}
