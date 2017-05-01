package com.mapper;

import com.model.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    Manager selectByPrimaryKey(Integer id);
    Manager selectByUsername(String username);
    int updateByPrimaryKey(Manager record);
}