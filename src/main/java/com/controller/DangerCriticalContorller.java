package com.controller;

import com.common.JsonResult;
import com.common.domain.PageList;
import com.model.DangerCritical;
import com.service.DangerCriticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18.
 */
@RestController
@RequestMapping("/dangerCritical")
public class DangerCriticalContorller {
    @Autowired
    private DangerCriticalService dangerCriticalService;

    //查询危险品
    @RequestMapping(value="/select", method= RequestMethod.GET)
    public JsonResult selectDanger(@RequestParam(value = "criticalName",required = false)String criticalName,
                            @RequestParam(value = "criticalType",required = false)String criticalType,
                            @RequestParam(value = "page",required = false)String page){
        try {
            PageList<DangerCritical> size=dangerCriticalService.searchSize(criticalName,criticalType, Integer.valueOf(page));
            int a=size.size()%10;
            String pageNumber="";
            if (a!=0) {
                pageNumber = String.valueOf((size.size() / 10 + 1)*10);
            }else {
                pageNumber = String.valueOf((size.size() / 10)*10);
            }

            PageList<DangerCritical> all=dangerCriticalService.search(criticalName,criticalType, Integer.valueOf(page));

            return new JsonResult("200", pageNumber,all);
        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }

    //根据名字模糊查询危险品
    @RequestMapping(value="/select/name", method= RequestMethod.GET)
    public JsonResult selectDangerByName(@RequestParam(value = "criticalName",required = false)String criticalName) {
        try {
            List<Map<String, String>> dangers = new ArrayList<>();
            List<String> dangerList = dangerCriticalService.selectByName2(criticalName);
            for (int i = 0; i < dangerList.size(); i++) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("value", dangerList.get(i));
                map.put("label", dangerList.get(i));
                dangers.add(map);
            }
                return new JsonResult("200", "查询成功", dangers);

        }catch(Exception e){

                return new JsonResult("500", e.getMessage());
            }
    }

    //根据名字模糊查询危险品的临界量
    @RequestMapping(value="/select/amount", method= RequestMethod.GET)
    public JsonResult selectAmountByName(@RequestParam(value = "criticalName",required = false)String criticalName) {
        try {
            DangerCritical dangerCritical=dangerCriticalService.selectAmountByName(criticalName);
            return new JsonResult("200", "查询成功",dangerCritical.getCriticalAmount());

        }catch(Exception e){

            return new JsonResult("500", e.getMessage());
        }
    }



    //根据list名字查询危险品的list的amount
    @RequestMapping(value="/select/amounts", method= RequestMethod.GET)
    public JsonResult selectAmountsByNames(@RequestParam(value = "criticalName",required = false)Map<String,String>[] criticalNames) {
        try {
            int length=criticalNames.length;
            List<Double> amounts=new ArrayList<>();
            for(int i=0;i<length;i++) {
                Map<String, String> map = criticalNames[i];
                DangerCritical dangerCritical=dangerCriticalService.selectAmountByName(map.get("name"));
                amounts.add(dangerCritical.getCriticalAmount());
            }
            return new JsonResult("200", "查询成功",amounts);

        }catch(Exception e){

            return new JsonResult("500", e.getMessage());
        }
    }

}
