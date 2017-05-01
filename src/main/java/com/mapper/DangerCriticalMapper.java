package com.mapper;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.model.DangerCritical;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DangerCriticalMapper {
    int deleteByPrimaryKey(Integer criticalId);

    int insert(DangerCritical record);

    int insertSelective(DangerCritical record);

    DangerCritical selectByPrimaryKey(Integer criticalId);
    DangerCritical selectAmountByName(String criticalName);



    int updateByPrimaryKeySelective(DangerCritical record);

    int updateByPrimaryKey(DangerCritical record);





    PageList<DangerCritical> selectAll(Map<String, Object> params, PageBounds pageBounds);
    PageList<DangerCritical> selectByName(Map<String, Object> params, PageBounds pageBounds);
    PageList<DangerCritical> selectByType(Map<String, Object> params, PageBounds pageBounds);
    PageList<DangerCritical> selectByNameAndType(Map<String, Object> params, PageBounds pageBounds);
    List<DangerCritical> selectByName2(String criticalName);
}