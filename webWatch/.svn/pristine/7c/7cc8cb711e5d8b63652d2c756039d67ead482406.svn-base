package com.watch.service;

import com.watch.bean.Shose;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.ShoseDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class ShoseServiceImpl implements ShoseService {

    @Resource
    private ShoseDAO shoseDAO;

    @Override
    public List<Shose> queryAll() {
        return null;
    }

    @Override
    public Shose queryById(Serializable id) {
        return shoseDAO.queryById(id);
    }

    @Override
    public void add(Shose shose) {
        shoseDAO.add(shose);
    }

    @Override
    public void update(Shose shose) {
        shoseDAO.update(shose);
    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public Pager4EasyUI<Shose> queryByPagerAndCriteria(Pager4EasyUI<Shose> pager, Shose shose) {
        List<Shose> shoses = shoseDAO.queryByPagerAndCriteria(pager,shose);
        pager.setRows(shoses);
        pager.setTotal(shoseDAO.countByCriteria(shose));
        return pager;
    }

    @Override
    public void updateImg(Shose shose) {
        shoseDAO.updateImg(shose);
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        shoseDAO.deleteByIds(list);
    }

    @Override
    public List<Shose> queryByBrand(Pager pager, Shose shose) {
        return shoseDAO.queryByBrand(pager, shose);
    }

    @Override
    public int countByBrand(Shose shose) {
        return shoseDAO.countByBrand(shose);
    }

    @Override
    public List<Shose> queryBy12(int start, int over) {
        return shoseDAO.queryBy12(start, over);
    }

    @Override
    public List<Shose> queryByPrice(Pager pager, Shose shose) {
        return shoseDAO.queryByPrice(pager, shose);
    }

    @Override
    public int countByPrice(Shose shose) {
        return shoseDAO.countByPrice(shose);
    }

    public List<String> getList(String id) {
        List<String> list = new ArrayList<String>();
        String[] str = id.split(",");
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }
}
