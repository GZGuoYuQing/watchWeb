package com.watch.service;

import com.watch.bean.Brand;
import com.watch.bean.Origin;


public interface OriginService extends BaseService<Origin> {
    public void deleteByIds(String id);
}
