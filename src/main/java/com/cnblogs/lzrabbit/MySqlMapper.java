package com.cnblogs.lzrabbit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年5月12日
 * @since	1.0	
 */
public interface MySqlMapper {

	@Select("select * from MyTable")
	List<Map<String, Object>> getList();
}
