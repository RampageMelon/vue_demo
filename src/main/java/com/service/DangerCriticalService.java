package com.service;

import com.common.domain.PageList;
import com.model.DangerCritical;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
public interface DangerCriticalService {

    PageList<DangerCritical> search(String criticalName,String criticalType,Integer page);
    PageList<DangerCritical> searchSize(String criticalName,String criticalType,Integer page);
    List<String> selectByName2(String criticalName);
    DangerCritical selectAmountByName(String criticalName);
}
