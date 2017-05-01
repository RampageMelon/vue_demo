package com.mapper;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.model.DangerCritical;
import com.model.LawFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LawFileMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(LawFile record);

    LawFile selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKey(LawFile record);

    LawFile selectByName(String fileName);
    PageList<LawFile> selectAll(Map<String, Object> params, PageBounds pageBounds);
}