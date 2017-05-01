package com.controller;

import com.common.JsonResult;
import com.common.domain.PageList;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("/user")
public class UserContorller {
    @Autowired
    private UserService userService;

    //根据id获取用户信息
    @RequestMapping(value="/select", method= RequestMethod.GET)
    public JsonResult selectUser(@RequestParam(value = "id",required = false)String id){
        try {
            User user=userService.selectByPrimaryKey(Integer.valueOf(id));
            return new JsonResult("200", "查询成功",user);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }

    //查询全部用户(分页)
    @RequestMapping(value="/selectall", method= RequestMethod.GET)
    public JsonResult selectAllUser(@RequestParam(value = "page",required = false)String page,
                                 @RequestParam(value = "username",required = false)String username){
        try {
            PageList<User> size=userService.searchSize(username,Integer.valueOf(page));
            int a=size.size()%10;
            String pageNumber="";
            if (a!=0) {
                pageNumber = String.valueOf((size.size() / 10 + 1)*10);
            }else {
                pageNumber = String.valueOf((size.size() / 10)*10);
            }

            PageList<User> all=userService.search(username,Integer.valueOf(page));

            return new JsonResult("200", pageNumber,all);

        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }
    //登录处理
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public JsonResult login(@RequestParam(value = "username",required = false)String username,
                            @RequestParam(value = "password",required = false)String password){
        try {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1=userService.selectByUsername(user);
            return new JsonResult("200", "登录成功",user1);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }
        @RequestMapping(value="/test", method= RequestMethod.GET)
        public JsonResult test(){
            return new JsonResult("500","不存在此用户");
    }
    //注册处理
    @RequestMapping(value="/regiter", method= RequestMethod.GET)
    public JsonResult register(@RequestParam(value = "username",required = false)String username,
                                 @RequestParam(value = "password",required = false)String password,
                                 @RequestParam(value = "deptCode",required = false)String deptCode,
                                 @RequestParam(value = "deptName",required = false)String deptName,
                                 @RequestParam(value = "address",required = false)String address,
                                 @RequestParam(value = "phone",required = false)String phone,
                                 @RequestParam(value = "principal",required = false)String principal,
                                 @RequestParam(value = "email",required = false)String email,
                                 @RequestParam(value = "businessScope",required = false)String businessScope){
        try {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setDeptCode(deptCode);
            user.setDeptName(deptName);
            user.setAddress(address);
            user.setPhone(phone);
            user.setPrincipal(principal);
            user.setEmail(email);
            user.setBusinessScope(businessScope);
            userService.insert(user);
            return new JsonResult("200", "注册成功",user);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }
// 编辑
@RequestMapping(value="/update", method= RequestMethod.POST)
public JsonResult edit(@RequestParam(value = "id",required = false)String id,
                       @RequestParam(value = "username",required = false)String username,
                       @RequestParam(value = "password",required = false)String password,
                       @RequestParam(value = "deptCode",required = false)String deptCode,
                       @RequestParam(value = "deptName",required = false)String deptName,
                       @RequestParam(value = "address",required = false)String address,
                       @RequestParam(value = "phone",required = false)String phone,
                       @RequestParam(value = "principal",required = false)String principal,
                       @RequestParam(value = "email",required = false)String email,
                       @RequestParam(value = "businessScope",required = false)String businessScope){
    try {
        User user=userService.selectByPrimaryKey(Integer.valueOf(id));;
        user.setPassword(password);
        user.setUsername(username);
        user.setBusinessScope(businessScope);
        user.setEmail(email);
        user.setAddress(address);
        user.setDeptCode(deptCode);
        user.setDeptName(deptName);
        user.setPhone(phone);
        user.setPrincipal(principal);
        userService.updateByPrimaryKey(user);
        return new JsonResult("200", "更新成功",user);
    }catch (Exception e){

        return new JsonResult("500",e.getMessage());
    }
}

    //删除
    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public JsonResult deleteUser(@RequestParam(value = "id",required = false)String id){
        try {
            userService.deleteByPrimaryKey(Integer.valueOf(id));
            return new JsonResult("200", "删除成功");
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }









    //登录处理post
    @RequestMapping(value="/login2", method= RequestMethod.POST)
    public JsonResult postPeople1(@RequestParam(value = "username",required = false)String username,
                                 @RequestParam(value = "password",required = false)String password){
        try {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1=userService.selectByUsername(user);
            return new JsonResult("200", "登录成功",user1);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }



}
