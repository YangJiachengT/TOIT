package cn.liu.mapper;

import cn.liu.po.CouStage;
import cn.liu.po.CouStageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouStageMapper {
    long countByExample(CouStageExample example);

    int deleteByExample(CouStageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouStage record);

    int insertSelective(CouStage record);

    List<CouStage> selectByExample(CouStageExample example);

    CouStage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouStage record, @Param("example") CouStageExample example);

    int updateByExample(@Param("record") CouStage record, @Param("example") CouStageExample example);

    int updateByPrimaryKeySelective(CouStage record);

    int updateByPrimaryKey(CouStage record);
}