package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * ユーザー名に基づいて従業員を検索します。
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 従業員データを挿入します
     * @param employee
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user, status)" + "values" +
                                  "(#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status})")
	@AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);

    /**
     * ページネーション検索
     * @param employeePageQueryDTO
     */
     
	Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

	

	/**
     * idに基づいて従業員情報を検索します
     * @param employeePageQueryDTO
     */
	@Select("select * from employee where id = #{id}")
	Employee getById(Long id);
	
	
	/**
     * 従業員情報を編集します
     * @param  employee
     * @return
     */
	@AutoFill(value = OperationType.UPDATE)
	void update(Employee employee);

}
