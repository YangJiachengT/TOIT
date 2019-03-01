package cn.liu.service.course;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.liu.mapper.CouBaseMapper;
import cn.liu.mapper.CouPlaceMapper;
import cn.liu.mapper.CouStageMapper;
import cn.liu.mapper.CouTypeMapper;
import cn.liu.po.CouBase;
import cn.liu.po.CouPlace;
import cn.liu.po.CouStage;
import cn.liu.po.CouStageExample;
import cn.liu.po.CouType;
import cn.liu.util.DbUtils;
import cn.liu.util.aop.annotation.OperationLogDetail;
import cn.liu.util.aop.enums.OperationType;
import cn.liu.util.bean.Record;
import cn.liu.util.bean.Ret;

@Service
public class CourseServiceImpl {
	@Autowired CouTypeMapper couTypeMapper;
	@Autowired CouBaseMapper couBaseMapper;
	@Autowired CouStageMapper couStageMapper;
	@Autowired CouPlaceMapper couPlaceMapper;
	
	/*---------------------------课程类别---------------------------*/
	
	public List<Record> getCouTypeList(){
		StringBuilder sql = new StringBuilder();
		sql.append(" select ct.id,ct.course_name,ct.course_code,count(class_name)as classNum ");
		sql.append(" from cou_type ct ");
		sql.append(" 	left join cou_base cb on cb.course_code = ct.course_code ");
		sql.append(" group by ct.course_code ");
		return DbUtils.find(sql.toString());
	}
	@OperationLogDetail(detail = "添加课程",operationType = OperationType.INSERT)
	public Ret addCouType(CouType couType) {
		
		if(couType.getCourseCode() != null &&  StringUtils.isNotBlank(couType.getCourseName()) ) {
			try{
				couTypeMapper.insert(couType);
				return Ret.ok();
			}catch(Exception e){
				return Ret.fail().setMessage("课程代码重复");
			}
		}
		return Ret.fail().setMessage("空值输入");
	}
	@OperationLogDetail(detail = "删除课程",operationType = OperationType.DELETE)
	public Ret deleteCouType(Integer id) {
		couTypeMapper.deleteByPrimaryKey(id);
		return Ret.ok();
	}
	
	/*---------------------------开班---------------------------*/
	
	public List<Record> getCouBaseList(String couCode) {
		HashMap<String,Object> map = new HashMap<>();
		String sql = " select * from cou_base cb inner join sys_user u on u.id = cb.teacher_id where cb.course_code = #{course_code}";
		map.put("course_code", couCode);
		map.put("sql", sql);
		return DbUtils.findWithParas(map);
	}
	public Ret addCouBase(CouBase couBase) {
		int flag = couBaseMapper.insert(couBase);
		return flag > 0 ? Ret.ok() : Ret.fail();
	}
	
	/*---------------------------学习阶段---------------------------*/
	
	public List<CouStage> getStageList(String couBaseId) {
		CouStageExample couStageExample = new CouStageExample();
		CouStageExample.Criteria criteria = couStageExample.createCriteria();
		criteria.andCourseIdEqualTo(Integer.parseInt(couBaseId));
		return couStageMapper.selectByExample(couStageExample);
	}
	public Ret addCouStage(CouStage couStage) {
		int flag = couStageMapper.insert(couStage);
		return flag > 0 ? Ret.ok() : Ret.fail();
	}
	public Ret deleteCouStage(String couStageId) {
		int flag = couStageMapper.deleteByPrimaryKey(Integer.parseInt(couStageId));
		return flag > 0 ? Ret.ok() : Ret.fail();
	}
	
	/*---------------------------上课地点（字典数据）---------------------------*/
	
	public List<Record> getCouPlaceList(){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT id,place_name ");
		sql.append("  FROM cou_place ");
		return DbUtils.find(sql.toString());
	}
	public Ret addCouPlace(CouPlace couPlace) {
		int flag = couPlaceMapper.insert(couPlace);
		return flag > 0 ? Ret.ok() : Ret.fail();
	}
	public Ret deleteCouPlace(String couPlaceId) {
		int flag = couPlaceMapper.deleteByPrimaryKey(Integer.parseInt(couPlaceId));
		return flag > 0 ? Ret.ok() : Ret.fail();
	}
}
