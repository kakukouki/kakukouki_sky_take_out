package com.sky.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "従業員のログイン時の返り値のデータ形式")
public class EmployeeLoginVO implements Serializable {

    @ApiModelProperty("主キー値")
    private Long id;

    @ApiModelProperty("ユーザー名")
    private String userName;

    @ApiModelProperty("名前")
    private String name;

    @ApiModelProperty("JWTトークン")
    private String token;
}
