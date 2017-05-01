package com.service;

import com.common.domain.PageList;
import com.model.LawFile;

/**
 * Created by Administrator on 2017/4/27.
 */
public interface LawFileService {

    PageList<LawFile> search(Integer page);
    PageList<LawFile> searchSize(Integer page);
    LawFile selectByName(String fileName);
}
