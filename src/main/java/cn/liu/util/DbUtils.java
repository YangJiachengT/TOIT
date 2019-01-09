package cn.liu.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.liu.mapper.DbMapper;
import cn.liu.util.bean.Record;
@Component
public class DbUtils {
	/**
	 * spring 不支持注入类变量和类方法，在工具类中需要用到mapper或者service时可以使用如下方法
	 * 
	 * 0.使用@Component注解工具类
	 * 
	 * 1.@Autowired注解需要用到的mapper和service
	 * 
	 * 2.申明一个静态工具变量 public static Utils utils
	 * 
	 * 3.@PostConstruct
		 public void init() {
			 utils = this;
		 }
	 */
	@Autowired 
	private DbMapper dbMapper;
	
	public static DbUtils dbUtils;
	@PostConstruct
	public void init() {
		dbUtils = this;
	}
	public static List<Record> find(String sql){
		return dbUtils.dbMapper.find(sql);
	}
	public static List<Record> findWithParas(HashMap<String,Object> map){
		return dbUtils.dbMapper.findWithParas(map);
	}
	/**
	 * 
	 * @Description: sql:UPDATE table_name SET field1=new-value1, field2=new-value2    
	 * @author liu
	 * @version 2018 年 12 月 11 日  14:09:34 
	 * @param sql
	 * @return
	 */
	public static int update(String sql){
		return dbUtils.dbMapper.update(sql);
	}
	/**
	 * 
	 * @Description: sql:UPDATE table_name SET field1=new-value1, field2=new-value2    
	 * @author liu
	 * @version 2018 年 12 月 11 日  14:09:34 
	 * @param sql
	 * @return
	 */
	public static int updateWithParas(HashMap<String, Object> map){
		return dbUtils.dbMapper.updateWithParas(map);
	}
	/**
	 * 
	 * @Description: sql:DELETE FROM table_name [WHERE Clause]    
	 * @author liu
	 * @version 2018 年 12 月 11 日  14:09:34 
	 * @param sql
	 * @return
	 */
	public static int delete(String sql){
		return dbUtils.dbMapper.delete(sql);
	}
	/**
	 * 
	 * @Description: sql:DELETE FROM table_name [WHERE Clause]    
	 * @author liu
	 * @version 2018 年 12 月 11 日  14:09:34 
	 * @param sql
	 * @return
	 */
	public static int deleteWithParas(HashMap<String, Object> map){
		return dbUtils.dbMapper.deleteWithParas(map);
	}
}
