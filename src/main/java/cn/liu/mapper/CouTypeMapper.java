package cn.liu.mapper;

import cn.liu.po.CouType;
import cn.liu.po.CouTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouTypeMapper {
    long countByExample(CouTypeExample example);

    int deleteByExample(CouTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouType record);

    int insertSelective(CouType record);

    List<CouType> selectByExample(CouTypeExample example);

    CouType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouType record, @Param("example") CouTypeExample example);

    int updateByExample(@Param("record") CouType record, @Param("example") CouTypeExample example);

    int updateByPrimaryKeySelective(CouType record);

    int updateByPrimaryKey(CouType record);
}