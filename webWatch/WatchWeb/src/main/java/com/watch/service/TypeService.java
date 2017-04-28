package com.watch.service;

import com.watch.bean.Forum;
import com.watch.bean.Type;
import com.watch.common.bean.Pager;

import java.util.List;


public interface TypeService extends BaseService<Type> {
    public Type queryByDes(String des);
    public void deleteByIds(String id);
}

