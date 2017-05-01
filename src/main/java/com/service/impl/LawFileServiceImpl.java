package com.service.impl;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.mapper.LawFileMapper;
import com.model.LawFile;
import com.model.Record;
import com.service.LawFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/27.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("lawFileService")
public class LawFileServiceImpl implements LawFileService{
    @Autowired
    private LawFileMapper lawFileMapper;


    public PageList<LawFile> search(Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer pageSize = 10;
        return lawFileMapper.selectAll(params, new PageBounds(page, pageSize));
    }

    @Override
    public PageList<LawFile> searchSize(Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        page=1;
        Integer pageSize = 20000;
        return lawFileMapper .selectAll(params, new PageBounds(page, pageSize));
    }

    public LawFile selectByName(String fileName){
        return lawFileMapper.selectByName(fileName);
    }
}
