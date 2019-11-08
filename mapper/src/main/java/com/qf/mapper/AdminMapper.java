package com.qf.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qf.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname AdminMapper
 * @Description TODO
 * @Date 2019/11/3 8:51
 * @Created by
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {
int deleteAll();
}
