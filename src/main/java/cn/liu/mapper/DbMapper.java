package cn.liu.mapper;

import java.util.HashMap;
import java.util.List;

import cn.liu.util.bean.Record;

public interface DbMapper {
	/**
	 * 
	 * @Description: 简单的查找语句   
	 * @author liu
	 * @version 2018 年 12 月 11 日  13:36:21 
	 * @param sql
	 * @return
	 */
	public List<Record> find(String sql);
	/**
	 * 
	 * @Description: 带参数的查找语句 
	 * 使用:
	 * 		StringBuilder sql = new StringBuilder();
	 * 		sql.append(" select * from table ");
	 * 		sql.append(" 	where para = #{para} ");
	 * 		map.put("para",para);
	 * 
	 * 		sql.append(" 	and ...")
	 * 		map.put(...);
	 * 		//最后执行
	 * 		map.put("sql",sql.toString)   
	 * @author liu
	 * @version 2018 年 12 月 11 日  13:37:03 
	 * @param map
	 * 
	 * @return
	 */
	public List<Record> findWithParas(HashMap<String,Object> map);
	/**
	 * 
	 * @Description: 简单更新    
	 * @author liu
	 * @version 2018 年 12 月 11 日  13:45:32 
	 * @param sql
	 * UPDATE table_name SET field1=new-value1, field2=new-value2
	 * @return
	 */
	public int update(String sql);
	/**
	 * 
	 * @Description: 带参更新    
	 * @author liu
	 * @version 2018 年 12 月 11 日  13:50:13 
	 * UPDATE table_name SET field1=new-value1, field2=new-value2
	 * @param map
	 * @return
	 */
	public int updateWithParas(HashMap<String,Object> map);
	/**
	 * 
	 * @Description: 简单删除   
	 * @author liu
	 * @version 2018 年 12 月 11 日  13:45:32 
	 * @param sql
	 * DELETE FROM table_name [WHERE Clause]
	 * @return
	 */
	public int delete(String sql);
	/**
	 * 
	 * @Description: 带参删除  
	 * @author liu
	 * @version 2018 年 12 月 11 日  13:45:32 
	 * @param sql
	 * DELETE FROM table_name [WHERE Clause]
	 * @return
	 */
	public int deleteWithParas(HashMap<String,Object> map);
}
