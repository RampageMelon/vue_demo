package com.service.impl;

import com.common.domain.PageBounds;
import com.common.domain.PageList;
import com.mapper.DangerCriticalMapper;
import com.model.DangerCritical;
import com.service.DangerCriticalService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("dangerCriticalService")
public class DangerCriticalServiceImpl implements DangerCriticalService {

    @Autowired
    private DangerCriticalMapper dangerCriticalMapper;

    @Override
    public PageList<DangerCritical> search(String criticalName, String criticalType, Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        Integer pageSize = 10;
        if (criticalName.equals("") && criticalType.equals("全部")) {
            return dangerCriticalMapper.selectAll(params, new PageBounds(page, pageSize));
        } else if (!criticalName.equals("") && criticalType.equals("全部")) {
            params.put("criticalName", "%"+criticalName+"%");
            return dangerCriticalMapper.selectByName(params, new PageBounds(page, pageSize));
        } else if (criticalName.equals("") && !criticalType.equals("全部")) {
            params.put("criticalType", criticalType);
            return dangerCriticalMapper.selectByType(params, new PageBounds(page, pageSize));
        } else if (!criticalName.equals("") && !criticalType.equals("全部")) {
            params.put("criticalName", "%"+criticalName+"%");
            params.put("criticalType", criticalType);
            return dangerCriticalMapper.selectByNameAndType(params, new PageBounds(page, pageSize));
        }
            return dangerCriticalMapper.selectByNameAndType(params, new PageBounds(page, pageSize));
    }

    @Override
    public PageList<DangerCritical> searchSize(String criticalName, String criticalType, Integer page) {
        Map<String, Object> params = new HashMap<String, Object>();
        page=1;
        Integer pageSize = 200;
        if (criticalName.equals("") && criticalType.equals("全部")) {
            return dangerCriticalMapper.selectAll(params, new PageBounds(page, pageSize));
        } else if (!criticalName.equals("") && criticalType.equals("全部")) {
            params.put("criticalName", "%"+criticalName+"%");
            return dangerCriticalMapper.selectByName(params, new PageBounds(page, pageSize));
        } else if (criticalName.equals("") && !criticalType.equals("全部")) {
            params.put("criticalType", criticalType);
            return dangerCriticalMapper.selectByType(params, new PageBounds(page, pageSize));
        } else if (!criticalName.equals("") && !criticalType.equals("全部")) {
            params.put("criticalName", "%"+criticalName+"%");
            params.put("criticalType", criticalType);
            return dangerCriticalMapper.selectByNameAndType(params, new PageBounds(page, pageSize));
        }
        return dangerCriticalMapper.selectByNameAndType(params, new PageBounds(page, pageSize));
    }

    public List<String> selectByName2(String criticalName){
        List<DangerCritical> dangerCriticals=new ArrayList<>();
        dangerCriticals=dangerCriticalMapper.selectByName2("%"+criticalName+"%");
        List<String> list=new ArrayList<>();
        for(int i=0;i<dangerCriticals.size();i++) {
            DangerCritical dangerCritical=dangerCriticals.get(i);
            list.add(dangerCritical.getCriticalName());
        }
            return list;
    }

    public DangerCritical selectAmountByName(String criticalName){
        return dangerCriticalMapper.selectAmountByName(criticalName);
    };
}
