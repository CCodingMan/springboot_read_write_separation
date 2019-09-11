package com.ljj.springboot_read_write_separation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: ljj
 * @Date: 2019/9/10 14:29
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -4567641993623143380L;

    private Long id;
    private String name;
    private int age;
}
