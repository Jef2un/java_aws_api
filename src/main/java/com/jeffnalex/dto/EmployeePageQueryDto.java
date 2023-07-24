package com.jeffnalex.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeePageQueryDto implements Serializable {
    private String name;

    private Short gender;

    private LocalDate begin;

    private LocalDate end;

    private int page;

    private int pageSize;

}
