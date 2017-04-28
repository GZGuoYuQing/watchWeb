package com.watch.service;

import com.watch.bean.Brand;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.BrandDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandDAO brandDAO;

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        brandDAO.deleteByIds(list);
    }

    @Override
    public Brand queryByDes(String des) {
        return brandDAO.queryByDes(des);
    }

    @Override
    public List<Brand> queryAll() {
        return brandDAO.queryAll();
    }

    @Override
    public Brand queryById(Serializable id) {
        return brandDAO.queryById(id);
    }

    @Override
    public void add(Brand brand) {
        brandDAO.add(brand);
    }

    @Override
    public void update(Brand brand) {
        brandDAO.update(brand);
    }

    @Override
    public void deleteById(Serializable id) {
        brandDAO.deleteById(id);
    }

    @Override
    public Pager4EasyUI<Brand> queryByPagerAndCriteria(Pager4EasyUI<Brand> pager, Brand brand) {
        List<Brand> brands = brandDAO.queryByPagerAndCriteria(pager, brand);
        pager.setRows(brands);
        pager.setTotal(brandDAO.countByCriteria(brand));
        return pager;
    }

    /*删除多行*/
    public List<String> getList(String id) {
        List<String> list = new ArrayList<String>();
        String[] str = id.split(",");
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }
}
