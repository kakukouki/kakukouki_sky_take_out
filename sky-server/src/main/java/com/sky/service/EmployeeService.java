package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 従業員のログイン
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    
	/*   
	 * 従業員の新規追加
	 * @param employeeDTO
	 *
	 * */
	void save(EmployeeDTO employeeDTO);

	/**
     * ページネーション検索
     * @param employeePageQueryDTO
     * @return
     */
	PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

	/**
     * 従業員アカウントの有効化/無効化を設定します
     * @param status, id
     * @return
     */
	void startOrStop(Integer status, Long id);

}
