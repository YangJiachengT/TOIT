package cn.liu.mapper;

import cn.liu.po.CouMultiQuestion;
import cn.liu.po.CouMultiQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouMultiQuestionMapper {
    long countByExample(CouMultiQuestionExample example);

    int deleteByExample(CouMultiQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouMultiQuestion record);

    int insertSelective(CouMultiQuestion record);

    List<CouMultiQuestion> selectByExample(CouMultiQuestionExample example);

    CouMultiQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouMultiQuestion record, @Param("example") CouMultiQuestionExample example);

    int updateByExample(@Param("record") CouMultiQuestion record, @Param("example") CouMultiQuestionExample example);

    int updateByPrimaryKeySelective(CouMultiQuestion record);

    int updateByPrimaryKey(CouMultiQuestion record);
}