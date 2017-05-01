package com.service;

import com.common.domain.PageList;
import com.model.DangerCritical;
import com.model.Record;

/**
 * Created by Administrator on 2017/4/26.
 */
public interface RecordService {

    void insert(String recordUsername,String recordName) ;
    PageList<Record> search(String recordUsername, Integer page);
    PageList<Record> searchSize(String recordUsername,Integer page);
}
