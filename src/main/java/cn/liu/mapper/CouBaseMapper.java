package cn.liu.mapper;

import cn.liu.po.CouBase;
import cn.liu.po.CouBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouBaseMapper {
    long countByExample(CouBaseExample example);

    int deleteByExample(CouBaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouBase record);

    int insertSelective(CouBase record);

    List<CouBase> selectByExample(CouBaseExample example);

    CouBase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouBase record, @Param("example") CouBaseExample example);

    int updateByExample(@Param("record") CouBase record, @Param("example") CouBaseExample example);

    int updateByPrimaryKeySelective(CouBase record);

    int updateByPrimaryKey(CouBase record);
}