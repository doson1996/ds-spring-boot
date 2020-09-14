package com.ds.tests;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author ds
 * @Date 2020/9/1 19:37
 * @Version 1.0
 * @Description
 */

@SpringBootTest
public class DataSourceTest {

    @Resource
    private DruidDataSource dataSource;

    @Test
    public void druid() throws SQLException {
        System.out.println(dataSource);
    }


}
