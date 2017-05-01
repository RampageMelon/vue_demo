package com.service;

import com.common.domain.PageList;
import com.model.User;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface UserService {
    User selectByUsername(User user);
    User updateByPrimaryKey(User user);
    User selectByPrimaryKey(Integer id);
    void deleteByPrimaryKey(Integer id);
    int insert(User record);
    PageList<User> search(String username,Integer page);
    PageList<User> searchSize(String username,Integer page);
}
