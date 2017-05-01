package com.service.impl;

import com.common.domain.PeopleException;
import com.mapper.ManagerMapper;
import com.model.Manager;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/4/12.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;


    public Manager selectByUsername(Manager manager) {
        if (StringUtils.isEmpty(manager.getUsername())) {
            throw new PeopleException("用户名不能为空！");
        } else if (StringUtils.isEmpty(manager.getPassword())) {
            throw new PeopleException("密码不能为空！");
        } else {
            Manager manager1 = managerMapper.selectByUsername(manager.getUsername());
            if (manager1 == null) {
                throw new PeopleException("不存在此用户名！");
            } else {
                String password1 = manager1.getPassword();
                if (!password1.equals(manager.getPassword())) {
                    throw new PeopleException("密码错误！请重新输入！");
                }
                return manager1;
            }
        }
    }
}
