package com.mapper;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
    void deleteByPrimaryKey(Integer id);
    int insert(User record);
    User selectByPrimaryKey(Integer id);
    User selectByUsername(String username);
    int updateByPrimaryKey(User record);

    PageList<User> selectAll(Map<String, Object> params, PageBounds pageBounds);
    PageList<User> selectAllByName(Map<String, Object> params, PageBounds pageBounds);
}