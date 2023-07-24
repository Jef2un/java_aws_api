package com.jeffnalex.controller;


import com.jeffnalex.constant.ErrorMsgConstant;
import com.jeffnalex.dto.EmployeePageQueryDto;
import com.jeffnalex.dto.LoginDTO;
import com.jeffnalex.entity.Employee;
import com.jeffnalex.result.PageResult;
import com.jeffnalex.result.Result;
import com.jeffnalex.service.EmpService;
import com.jeffnalex.utils.JwtUtil;
import com.jeffnalex.vo.EmpLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result<PageResult> page(EmployeePageQueryDto employeePageQueryDto){
        log.info("查詢資料{}", employeePageQueryDto);
        PageResult pageResult = empService.page(employeePageQueryDto);
        return Result.success(pageResult);
    }

    @PostMapping("/login")
    public Result<EmpLoginVO> login(LoginDTO loginDTO){
        Employee employee = empService.login(loginDTO);
        // 如果登入成功後生成令牌
        if(employee != null){
            Map<String, Object> claim = new HashMap<>();
            claim.put("id",employee.getId());
            claim.put("username",employee.getUsername());
            String jwtToken = JwtUtil.createJWT(claim);

            EmpLoginVO empLoginVO = EmpLoginVO.builder()
                    .id(employee.getId())
                    .username(employee.getUsername())
                    .name(employee.getName())
                    .token(jwtToken)
                    .build();
            return Result.success(empLoginVO);
        }else {
            return Result.error(ErrorMsgConstant.USER_NOT_LOGIN);
        }

    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Employee employee){
        empService.insert(employee);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Employee> getById(@PathVariable Long id){
        Employee employee = empService.getById(id);

        return Result.success(employee);
    }

    @PutMapping
    public Result update(@RequestBody Employee employee){
        empService.update(employee);
        return Result.success();
    }



}
