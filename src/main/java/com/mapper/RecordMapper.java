package com.mapper;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.model.DangerCritical;
import com.model.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    Record selectByPrimaryKey(Integer recordId);


    PageList<Record> selectByUsername(Map<String, Object> params, PageBounds pageBounds);

}