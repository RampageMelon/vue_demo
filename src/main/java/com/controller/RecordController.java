package com.controller;

import com.common.JsonResult;
import com.common.domain.PageList;
import com.model.DangerCritical;
import com.model.Record;
import com.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/26.
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    //查询危险品(分页)
    @RequestMapping(value="/select", method= RequestMethod.GET)
    public JsonResult selectDanger(@RequestParam(value = "recordUsername",required = false)String recordUsername,
                                   @RequestParam(value = "page",required = false)String page){
        try {
            PageList<Record> size=recordService.searchSize(recordUsername,Integer.valueOf(page));
            int a=size.size()%10;
            String pageNumber="";
            if (a!=0) {
                pageNumber = String.valueOf((size.size() / 10 + 1)*10);
            }else {
                pageNumber = String.valueOf((size.size() / 10)*10);
            }

            PageList<Record> all=recordService.search(recordUsername,Integer.valueOf(page));

            return new JsonResult("200", pageNumber,all);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }


    //注册处理
    @RequestMapping(value="/regiter", method= RequestMethod.GET)
    public JsonResult register(@RequestParam(value = "recordUsername",required = false)String recordUsername,
                               @RequestParam(value = "recordName",required = false)String recordName){
//            try {
                recordService.insert(recordUsername,recordName);
                return new JsonResult("200","注册成功");
//            }catch (Exception e){

//                return new JsonResult("500",e.getMessage());
//            }

    }

}
