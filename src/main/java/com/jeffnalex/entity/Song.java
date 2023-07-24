package com.jeffnalex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Song implements Serializable {
    private Long id;
    private String name;
    private String artist;
}
