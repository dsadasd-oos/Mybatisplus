package com.qf.pojo;
import	java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
//
//public class Employee {
//    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
//    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
//    private Integer id;
//    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，exist标明数据表中有没有对应列
//    @TableField(value = "last_name",exist = true)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
@TableName(value = "admin")//指定表名
public class Admin extends Model<Admin> implements Serializable {
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
   @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;
    @TableField(value = "username",exist = true)
    private String username;
    @TableField(value = "password",exist = true)
    @TableLogic//逻辑删除
    private String password;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}


