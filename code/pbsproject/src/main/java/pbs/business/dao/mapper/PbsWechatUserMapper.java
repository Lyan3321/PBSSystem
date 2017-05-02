package pbs.business.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pbs.business.pojo.po.PbsWechatUser;
import pbs.business.pojo.po.PbsWechatUserExample;

public interface PbsWechatUserMapper {
    int countByExample(PbsWechatUserExample example);

    int deleteByExample(PbsWechatUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PbsWechatUser record);

    int insertSelective(PbsWechatUser record);

    List<PbsWechatUser> selectByExample(PbsWechatUserExample example);

    PbsWechatUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PbsWechatUser record, @Param("example") PbsWechatUserExample example);

    int updateByExample(@Param("record") PbsWechatUser record, @Param("example") PbsWechatUserExample example);

    int updateByPrimaryKeySelective(PbsWechatUser record);

    int updateByPrimaryKey(PbsWechatUser record);
}