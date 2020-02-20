package com.greenjava.securityjwt.controller;

import com.greenjava.securityjwt.model.Students;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/version/student")
public class StudentController {


    @GetMapping(path = "{students}")
    //@PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_USER')")
    public Students getStudents(@PathVariable("students") Integer id ) {
        List<Students> students = Arrays.asList(
                new Students(1, "John"),
                new Students(2, "Sara"),
                new Students(3, "Smith")
        );
        return students.stream().
                filter(students1 -> students1.getId()==id)
                .findFirst()
                .orElseThrow(()->new IllegalStateException(""));
    }

}
