package com.cnblogs.lzrabbit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年5月12日
 * @since	1.0	
 */
public class Main {

	public static void main(String[] args) {
		// 初始化ApplicationContext
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		MySqlMapper mySqlMapper = applicationContext.getBean(MySqlMapper.class);

		SqlServerMapper sqlServerMapper = applicationContext.getBean(SqlServerMapper.class);

		// 设置数据源为MySql,使用了AOP测试时请将下面这行注释
		MultipleDataSource.setDataSourceKey("mySqlDataSource");
		mySqlMapper.getList();
		// 设置数据源为SqlServer,使用AOP测试时请将下面这行注释
		MultipleDataSource.setDataSourceKey("sqlServerDataSource");
		sqlServerMapper.getList();
	}
}
