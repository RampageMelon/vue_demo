package com.common;


import com.common.domain.PageList;

/**
 * Created by Administrator on 2015-09-11.
 */
public class DTJsonResult extends JsonResult {
    public DTJsonResult(Integer draw, PageList pageList){
        if(pageList != null){
            this.draw = draw;
            this.recordsTotal = pageList.getPaginator().getTotalCount();
            this.recordsFiltered = pageList.getPaginator().getTotalCount();
            setData(pageList);
        }
    }

    public Integer draw = 1;

    public Integer recordsTotal;

    public Integer recordsFiltered;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
