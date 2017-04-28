package com.watch.service;

import com.watch.bean.Core;
import com.watch.bean.Material;
import com.watch.bean.Origin;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.CoreDAO;
import com.watch.dao.OriginDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class OriginServiceImpl implements OriginService{

    @Resource
    private OriginDAO originDAO;


    @Override
    public List<Origin> queryAll() {
        return originDAO.queryAll();
    }

    @Override
    public Origin queryById(Serializable id) {
        return null;
    }

    @Override
    public void add(Origin origin) {
        originDAO.add(origin);
    }

    @Override
    public void update(Origin origin) {
        originDAO.update(origin);
    }

    @Override
    public void deleteById(Serializable id) {
        originDAO.deleteById(id);
    }

    @Override
    public Pager4EasyUI<Origin> queryByPagerAndCriteria(Pager4EasyUI<Origin> pager, Origin origin) {
        List<Origin> origins = originDAO.queryByPagerAndCriteria(pager, origin);
        pager.setRows(origins);
        pager.setTotal(originDAO.countByCriteria(origin));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
       List<String> list =  getList(id);
       originDAO.deleteByIds(list);
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
