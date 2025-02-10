package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    private Long id;

    // 用户名
    private String username;

    // 姓名
    private String name;

    private String phone;

    private String sex;

    // 身份证号
    private String idNumber;

}
