package com.jeffnalex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private Long id;

    private String username;

    private String name;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entry_date;

    private Short gender;

    private Short job;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate create_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate update_time;

    private Long create_user;

    private Long update_user;



}
