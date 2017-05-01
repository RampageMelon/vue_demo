package com.controller;

import com.common.JsonResult;
import com.common.domain.PageList;
import com.model.LawFile;
import com.model.Record;
import com.service.LawFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/27.
 */
@RestController
@RequestMapping("/lawfile")
public class LawFileController {

    @Autowired
    private LawFileService lawFileService;


    //查询全部文件(分页)
    @RequestMapping(value="/selectall", method= RequestMethod.GET)
    public JsonResult selectDanger(@RequestParam(value = "page",required = false)String page){
        try {
            PageList<LawFile> size=lawFileService.searchSize(Integer.valueOf(page));
            int a=size.size()%10;
            String pageNumber="";
            if (a!=0) {
                pageNumber = String.valueOf((size.size() / 10 + 1)*10);
            }else {
                pageNumber = String.valueOf((size.size() / 10)*10);
            }

            PageList<LawFile> all=lawFileService.search(Integer.valueOf(page));

            return new JsonResult("200", pageNumber,all);

        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }

    @RequestMapping(value="/selectcontent", method= RequestMethod.GET)
    public JsonResult selectByName(@RequestParam(value = "fileName",required = false)String fileName){
        try {

            LawFile lawFile=lawFileService.selectByName(fileName);

            String content =lawFile.getFileContent();
            return new JsonResult("200", "查询内容成功",content);

        }catch (Exception e){

            return new JsonResult("500",e.getMessage());
        }
    }
}
