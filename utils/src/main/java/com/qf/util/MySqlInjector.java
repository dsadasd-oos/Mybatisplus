package com.qf.util;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.springframework.stereotype.Repository;

import	java.awt.Component;

/**
 * @Classname MySqlInjector
 * @Description TODO
 * @Date 2019/11/3 16:40
 * @Created by
 */
@Repository
public class MySqlInjector  extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        // 构造sql语句
        String sql = "delete  from admin where id =3" ;
        // 构造方法名
        String method = "deleteAll";
        // 构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        // 构造一个查找的MapperStatement
        this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}

