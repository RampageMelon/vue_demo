package com.service.impl;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.common.domain.PeopleException;
import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/12.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUsername(User user) {
        if (StringUtils.isEmpty(user.getUsername())) {
            throw new PeopleException("用户名不能为空！");
        } else if (StringUtils.isEmpty(user.getPassword())) {
            throw new PeopleException("密码不能为空！");
        } else {
            User user1 = userMapper.selectByUsername(user.getUsername());
            if (user1 == null) {
                throw new PeopleException("不存在此用户名！");
            } else {
                String password1 = user1.getPassword();
                if (!password1.equals(user.getPassword())) {
                    throw new PeopleException("密码错误！请重新输入！");
                }
                return user1;
            }
        }
    }

    @Override
    public int insert(User user) {

        if (StringUtils.isEmpty(user.getUsername())){
            throw new PeopleException("用户名不能为空！");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            throw new PeopleException("密码不能为空！");
        }
        if (StringUtils.isEmpty(user.getDeptCode())){
            throw new PeopleException("单位编码不能为空！");
        }
        if (StringUtils.isEmpty(user.getPrincipal())){
            throw new PeopleException("负责人不能为空！");
        }
        if(user.getUsername().getBytes().length != user.getUsername().length()){
            throw new PeopleException("用户名不能有汉字");
        }else if(user.getUsername().contains(" ")){
            throw new PeopleException("用户名不能有空格");
        }
//        if (StringUtils.isEmpty(user.getDeptName())){
//            throw new PeopleException("单位名称不能为空！");
//        }
//        if (StringUtils.isEmpty(user.getPhone())){
//            throw new PeopleException("电话不能为空！");
//        }

//        if (StringUtils.isEmpty(user.getEmail())){
//            throw new PeopleException("邮箱不能为空！");
//        }
//        if (StringUtils.isEmpty(user.getBusinessScope())){
//            throw new PeopleException("请选择一项业务范围！");
//        }
        User user1=userMapper.selectByUsername(user.getUsername());
        if (user1!=null){
            throw new PeopleException("已存在此用户名，请使用其他用户名");
        }else {
            userMapper.insert(user);
        }
        return 0;
    }
    public User selectByPrimaryKey(Integer id){
        User user=userMapper.selectByPrimaryKey(id);
        if(user != null){
            return user;
        }else {
            throw new PeopleException("用户id出错，请与客服联系");
        }
    }
    public User updateByPrimaryKey(User user){
            userMapper.updateByPrimaryKey(user);
            return user;
    }

    public PageList<User> search(String username,Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer pageSize = 10;
        if(username.equals("")) {
            return userMapper.selectAll(params, new PageBounds(page, pageSize));
        }else {
            params.put("username","%"+username+"%");
            return userMapper.selectAllByName(params, new PageBounds(page, pageSize));
        }
    }


    @Override
    public PageList<User> searchSize(String username,Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        page=1;
        Integer pageSize = 20000;
        if(username.equals("")) {
            return userMapper.selectAll(params, new PageBounds(page, pageSize));
        }else {
            params.put("username","%"+username+"%");
            return userMapper.selectAllByName(params, new PageBounds(page, pageSize));
        }
    }

    public void deleteByPrimaryKey(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }
}
