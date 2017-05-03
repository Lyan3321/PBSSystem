package pbs.business.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pbs.business.pojo.po.PbsWechatOrder;
import pbs.business.pojo.po.PbsWechatOrderExample;

public interface PbsWechatOrderMapper {
    int countByExample(PbsWechatOrderExample example);

    int deleteByExample(PbsWechatOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PbsWechatOrder record);

    int insertSelective(PbsWechatOrder record);

    List<PbsWechatOrder> selectByExample(PbsWechatOrderExample example);

    PbsWechatOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PbsWechatOrder record, @Param("example") PbsWechatOrderExample example);

    int updateByExample(@Param("record") PbsWechatOrder record, @Param("example") PbsWechatOrderExample example);

    int updateByPrimaryKeySelective(PbsWechatOrder record);

    int updateByPrimaryKey(PbsWechatOrder record);
}