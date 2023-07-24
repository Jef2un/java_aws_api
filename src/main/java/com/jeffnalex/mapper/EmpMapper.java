package com.jeffnalex.mapper;

import com.github.pagehelper.Page;
import com.jeffnalex.dto.EmployeePageQueryDto;
import com.jeffnalex.entity.Employee;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {


    Page<Employee> pageQuery(EmployeePageQueryDto employeePageQueryDto);

    @Select("select * from emp where username = #{username}")
    Employee getByUsername(String username);

    void delete(List<Integer> ids);

    @Insert("insert into emp (name,username,gender,job,create_time,update_time,create_user,update_user) values (#{name},#{username},#{gender},#{job},#{create_time},#{update_time},#{create_user},#{update_user})")
    void insert(Employee employee);
    @Select("select * from emp where id = #{id}")
    Employee getById(Long id);

    void update(Employee employee);
}
