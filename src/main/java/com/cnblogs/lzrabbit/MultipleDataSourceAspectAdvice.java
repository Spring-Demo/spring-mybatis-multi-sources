package com.cnblogs.lzrabbit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年5月12日
 * @since	1.0	
 */
@Component
@Aspect
public class MultipleDataSourceAspectAdvice {

	@Around("execution(* com.cnblogs.lzrabbit.*.*(..))")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		if (jp.getTarget() instanceof MySqlMapper) {
			MultipleDataSource.setDataSourceKey("mySqlDataSource");
		} else if (jp.getTarget() instanceof SqlServerMapper) {
			MultipleDataSource.setDataSourceKey("sqlServerDataSource");
		}
		return jp.proceed();
	}
}
