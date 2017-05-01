package com.service.impl;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.mapper.RecordMapper;
import com.model.DangerCritical;
import com.model.Record;
import com.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/4/26.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;


    public PageList<Record> search(String recordUsername, Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer pageSize = 10;
        params.put("recordUsername",recordUsername);
        return recordMapper.selectByUsername(params, new PageBounds(page, pageSize));
    }

    @Override
    public PageList<Record> searchSize(String recordUsername, Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        page=1;
        Integer pageSize = 20000;
        params.put("recordUsername",recordUsername);
        return recordMapper.selectByUsername(params, new PageBounds(page, pageSize));
    }


    public void insert(String recordUsername,String recordName) {
        Record record=new Record();
        record.setRecordUsername(recordUsername);
        record.setRecordName(recordName);
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        record.setRecordTime(year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分");
        recordMapper.insert(record);
    }
}
