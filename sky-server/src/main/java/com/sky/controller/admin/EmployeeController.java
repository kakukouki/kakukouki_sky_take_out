package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "従業員関連のAPI")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     * 
     * @param employeeLoginDTO   
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "従業員ログイン")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation("従業員ログアウト")
    public Result<String> logout() {
        return Result.success();
    }
    
    @PostMapping
    @ApiOperation("従業員の新規追加")
    public Result save(@RequestBody EmployeeDTO employeeDTO){
    	log.info("従業員の新規追加: {}", employeeDTO);
    	System.out.println("現在のスレッドのID:" + Thread.currentThread().getId());
    	employeeService.save(employeeDTO);
    	return Result.success();
    }
   
    @GetMapping("/page")
    @ApiOperation("従業員のページネーション検索")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
    	log.info("従業員の新規追加、パラメータは：{}", employeePageQueryDTO);
    	PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
    	return Result.success(pageResult);
    }
    
    @PostMapping("/status/{status}")
    @ApiOperation("従業員アカウントの有効化/無効化を設定します")
    public Result startOrStop(@PathVariable Integer status, Long id) {
    	log.info("従業員アカウントの有効化/無効化を設定しま,{},{}",status, id);
    	employeeService.startOrStop(status, id);
    	return Result.success();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
