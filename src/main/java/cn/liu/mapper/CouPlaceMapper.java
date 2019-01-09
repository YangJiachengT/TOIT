package cn.liu.mapper;

import cn.liu.po.CouPlace;
import cn.liu.po.CouPlaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouPlaceMapper {
    long countByExample(CouPlaceExample example);

    int deleteByExample(CouPlaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouPlace record);

    int insertSelective(CouPlace record);

    List<CouPlace> selectByExample(CouPlaceExample example);

    CouPlace selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouPlace record, @Param("example") CouPlaceExample example);

    int updateByExample(@Param("record") CouPlace record, @Param("example") CouPlaceExample example);

    int updateByPrimaryKeySelective(CouPlace record);

    int updateByPrimaryKey(CouPlace record);
}