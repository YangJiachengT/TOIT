package cn.liu.mapper;

import cn.liu.po.CouPaper;
import cn.liu.po.CouPaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouPaperMapper {
    long countByExample(CouPaperExample example);

    int deleteByExample(CouPaperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouPaper record);

    int insertSelective(CouPaper record);

    List<CouPaper> selectByExample(CouPaperExample example);

    CouPaper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouPaper record, @Param("example") CouPaperExample example);

    int updateByExample(@Param("record") CouPaper record, @Param("example") CouPaperExample example);

    int updateByPrimaryKeySelective(CouPaper record);

    int updateByPrimaryKey(CouPaper record);
}