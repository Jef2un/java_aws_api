package com.jeffnalex.service;

import com.jeffnalex.dto.EmployeePageQueryDto;
import com.jeffnalex.dto.LoginDTO;
import com.jeffnalex.entity.Employee;
import com.jeffnalex.result.PageResult;
import com.jeffnalex.vo.EmpLoginVO;

import java.util.List;

public interface EmpService {
    PageResult page(EmployeePageQueryDto employeePageQueryDto);

    Employee login(LoginDTO loginDTO);

    void delete(List<Integer> ids);

    void insert(Employee employee);

    Employee getById(Long id);

    void update(Employee employee);
}
