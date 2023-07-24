package com.jeffnalex.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpLoginVO implements Serializable {
    private Long id ;
    private String username;
    private String name;
    private String token;

}
