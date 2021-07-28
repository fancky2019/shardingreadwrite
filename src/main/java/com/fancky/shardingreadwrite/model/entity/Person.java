package com.fancky.shardingreadwrite.model.entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * (Person)实体类
 *
 * @author fancky
 * @since 2021-07-23 15:38:48
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 779442762874983275L;
    
    private Integer id;
    
    private String name;

}