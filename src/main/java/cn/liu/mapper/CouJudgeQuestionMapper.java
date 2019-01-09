package cn.liu.mapper;

import cn.liu.po.CouJudgeQuestion;
import cn.liu.po.CouJudgeQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouJudgeQuestionMapper {
    long countByExample(CouJudgeQuestionExample example);

    int deleteByExample(CouJudgeQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouJudgeQuestion record);

    int insertSelective(CouJudgeQuestion record);

    List<CouJudgeQuestion> selectByExample(CouJudgeQuestionExample example);

    CouJudgeQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouJudgeQuestion record, @Param("example") CouJudgeQuestionExample example);

    int updateByExample(@Param("record") CouJudgeQuestion record, @Param("example") CouJudgeQuestionExample example);

    int updateByPrimaryKeySelective(CouJudgeQuestion record);

    int updateByPrimaryKey(CouJudgeQuestion record);
}