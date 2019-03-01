package cn.liu.controller.student.course;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.liu.util.DbUtils;
import cn.liu.util.bean.Record;

@Controller
@RequestMapping("/student/choose/course")
public class ChooseCourseController {
	/**
	 * @Description: 选课列表   
	 * @author liu
	 * @version 2019 年 02 月 28 日  15:01:28 
	 * @param couCode 类别
	 * @return
	 */
	public List<Record> list(String couCode){
		HashMap<String,Object> map = new HashMap<>();
		String sql = " select * from cou_base cb inner join sys_user u on u.id = cb.teacher_id where cb.course_code = #{course_code}";
		map.put("course_code", couCode);
		map.put("sql", sql);
		return DbUtils.findWithParas(map);
	}
}
