package cn.liu.mapper;

import cn.liu.po.CouScore;
import cn.liu.po.CouScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouScoreMapper {
    long countByExample(CouScoreExample example);

    int deleteByExample(CouScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouScore record);

    int insertSelective(CouScore record);

    List<CouScore> selectByExample(CouScoreExample example);

    CouScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouScore record, @Param("example") CouScoreExample example);

    int updateByExample(@Param("record") CouScore record, @Param("example") CouScoreExample example);

    int updateByPrimaryKeySelective(CouScore record);

    int updateByPrimaryKey(CouScore record);
}