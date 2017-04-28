package com.watch.service;


import com.watch.bean.Brand;


public interface BrandService extends BaseService<Brand> {

    public void deleteByIds(String id);

    public Brand queryByDes(String des);
}
