package cn.liu.controller.admin.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.liu.po.CouBase;
import cn.liu.po.CouStage;
import cn.liu.po.CouType;
import cn.liu.service.course.CourseServiceImpl;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired CourseServiceImpl courseServiceImpl;
	/*---------------------------课程类别---------------------------*/
	@RequestMapping("couTypeList")
	public List<Record> courseList(){
		return courseServiceImpl.getCouTypeList();
	}
	@RequestMapping("couTypeAdd")
	public Ret courseAdd(@RequestBody CouType couType){
		return courseServiceImpl.addCouType(couType);
	}
	@RequestMapping("couTypeDelete")
	public Ret courseDelete(@RequestBody Integer id){
		return courseServiceImpl.deleteCouType(id);
	}
	/*---------------------------开班---------------------------*/
	@RequestMapping("couBaseList")
	public List<Record> courseBaseList(@RequestParam String couCode){
		return courseServiceImpl.getCouBaseList(couCode);
	}
	@RequestMapping("couBaseAdd")
	public Ret courseBaseAdd(@RequestBody CouBase couBase){
		return courseServiceImpl.addCouBase(couBase);
	}
	/*---------------------------班级学习阶段---------------------------*/
	@RequestMapping("couStageList")
	public List<CouStage> couStageList(@RequestParam String couBaseId){
		return courseServiceImpl.getStageList(couBaseId);
	}
	@RequestMapping("couStageAdd")
	public Ret courseStageAdd(@RequestBody CouStage couStage){
		return courseServiceImpl.addCouStage(couStage);
	}
	
	/*---------------------------上课地点---------------------------*/
	
	@RequestMapping("couPlaceList")
	public List<Record> couPlaceList(){
		return courseServiceImpl.getCouPlaceList();
	}
}
