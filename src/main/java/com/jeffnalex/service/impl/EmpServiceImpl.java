package com.jeffnalex.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jeffnalex.constant.ErrorMsgConstant;
import com.jeffnalex.context.BaseContext;
import com.jeffnalex.dto.EmployeePageQueryDto;
import com.jeffnalex.dto.LoginDTO;
import com.jeffnalex.entity.Employee;
import com.jeffnalex.exception.AccountNotFoundException;
import com.jeffnalex.exception.PasswordFailException;
import com.jeffnalex.mapper.EmpMapper;
import com.jeffnalex.result.PageResult;
import com.jeffnalex.service.EmpService;
import com.jeffnalex.vo.EmpLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult page(EmployeePageQueryDto employeePageQueryDto) {
        PageHelper.startPage(employeePageQueryDto.getPage(),employeePageQueryDto.getPageSize());
        Page<Employee> page = empMapper.pageQuery(employeePageQueryDto);
        log.info("Service 開始...............................()",page);

        Long total = page.getTotal();
        List<Employee> records = page.getResult();

        return new PageResult(total,records);
    }

    @Override
    public Employee login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        // 因為username唯一 把對應的對象抓出來 如果為空就丟username錯誤
        Employee employee = empMapper.getByUsername(username);
        if (employee == null){
            throw new AccountNotFoundException(ErrorMsgConstant.ACCOUNT_NOT_FOUND);
        }
        // password md5加密後再進行比較
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!password.equals(employee.getPassword())){
            throw new PasswordFailException(ErrorMsgConstant.PASSWORD_ERROR);
        }

        return employee;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);

    }

    @Override
    public void insert(Employee employee) {
        employee.setCreate_time(LocalDate.now());
        employee.setUpdate_time(LocalDate.now());
        employee.setUpdate_user(BaseContext.getCurrentId());
        employee.setCreate_user(BaseContext.getCurrentId());
        empMapper.insert(employee);
    }

    @Override
    public Employee getById(Long id) {
        Employee employee =empMapper.getById(id);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        employee.setUpdate_time(LocalDate.now());
        employee.setUpdate_user(BaseContext.getCurrentId());
        empMapper.update(employee);

    }
}
