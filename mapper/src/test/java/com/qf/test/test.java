package com.qf.test;
import	java.util.ArrayList;
import	java.lang.annotation.Target;

import com.baomidou.mybatisplus.annotations.DataSource;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qf.mapper.AdminMapper;
import com.qf.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/11/3 10:33
 * @Created by
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class test {
    private ApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    AdminMapper adminMapper =
            context.getBean("adminMapper", AdminMapper.class);
    @Autowired
    private Admin admins;
    public void testDataSource() {

        System.out.println(adminMapper);
        Admin admin = adminMapper.selectById(1);
        System.out.println(admin);
    }
    @Test
    public void getEmpByPage() {
        Page<?> page = new Page<>(1, 5);
        List<Admin> list = adminMapper.selectPage(page, null);

        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数" + page.getPages());
        System.out.println(list);
    }
    @Test
    public void getEmpByName() {
        EntityWrapper<Admin> wrapper = new EntityWrapper<>();
        wrapper.like("username","a");

        List<Admin> list = adminMapper.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    public void getAdminList(){
        List list=new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        List list1 = adminMapper.selectBatchIds(list);
        System.out.println(list1);

    }
    @Test
    public void getAdminLists(){
        List<Admin> list = adminMapper.selectList(new EntityWrapper<Admin>()
        .eq("username","a")
                .between("password","3","4")
                .orNew()
                .like("username","a")
                .last("desc limit 1,3")
        );

    }
    @Test
    public void getAdminListas(){
        List<Admin> list = adminMapper.selectPage(new Page<Admin>(1, 2), new EntityWrapper<Admin>()
                .like("username", "ad"));
        System.out.println(list);

    }
    //测试AR
    @Test
    public void TestAr(){
//        Page<User> page = new Page<User>(1,4);
//        List<User> users = userMapper.selectPage(page,null);
//        page.setRecords(users);查询到的列表放到page中。
        Page<Admin> page = admins.selectPage(new Page<Admin>(1, 2), new EntityWrapper<Admin>()
                .like("username", "a"));
        System.out.println(page);
    }
    @Test
    public void testInject(){
        int rs = adminMapper.deleteAll();
        System.out.println(rs);
    }
}