package cn.liu.mapper;

import cn.liu.po.CouExam;
import cn.liu.po.CouExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouExamMapper {
    long countByExample(CouExamExample example);

    int deleteByExample(CouExamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouExam record);

    int insertSelective(CouExam record);

    List<CouExam> selectByExample(CouExamExample example);

    CouExam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouExam record, @Param("example") CouExamExample example);

    int updateByExample(@Param("record") CouExam record, @Param("example") CouExamExample example);

    int updateByPrimaryKeySelective(CouExam record);

    int updateByPrimaryKey(CouExam record);
}