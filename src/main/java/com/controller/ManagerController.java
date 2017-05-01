package com.controller;

import com.common.JsonResult;
import com.model.Manager;
import com.model.User;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/29.
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    //登录处理
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public JsonResult login(@RequestParam(value = "username",required = false)String username,
                            @RequestParam(value = "password",required = false)String password){
        try {
            Manager manager=new Manager();
            manager.setUsername(username);
            manager.setPassword(password);
            Manager manager1=managerService.selectByUsername(manager);
            return new JsonResult("200", "登录成功",manager1);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }

}
