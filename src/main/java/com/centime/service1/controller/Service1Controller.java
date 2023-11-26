package com.centime.service1.controller;

import com.centime.service1.dto.Customer;
import com.centime.service1.service.Service1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

@RestController
@RequestMapping("/service-one")
public class Service1Controller {
    @Autowired
    private Service1Service service;

    @GetMapping("/health")
    public String getHealth() {
        return "Up";
    }

    @PostMapping("/concatenated-string")
    public String getConcatenatedjson(@RequestBody @Valid Customer customer) {
        return service.getConcatenatedString(customer);

    }
}
