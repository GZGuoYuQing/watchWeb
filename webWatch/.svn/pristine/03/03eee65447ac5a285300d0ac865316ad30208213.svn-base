package com.watch.service;

import com.watch.bean.Leather;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.LeatherDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao-kang on 2017/4/11.
 */
@Service
public class leatherServiceImpl implements LeatherService {

    @Resource
    private LeatherDAO leatherDAO;

    @Override
    public List<Leather> queryAll() {
        return null;
    }

    @Override
    public Leather queryById(Serializable id) {
        return leatherDAO.queryById(id);
    }

    @Override
    public void add(Leather leather) {
        leatherDAO.add(leather);
    }

    @Override
    public void update(Leather leather) {
        leatherDAO.update(leather);
    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public Pager4EasyUI<Leather> queryByPagerAndCriteria(Pager4EasyUI<Leather> pager, Leather leather) {
        List<Leather> leathers = leatherDAO.queryByPagerAndCriteria(pager,leather);
        pager.setRows(leathers);
        pager.setTotal(leatherDAO.countByCriteria(leather));
        return pager;
    }

    @Override
    public void updateImg(Leather leather) {
        leatherDAO.updateImg(leather);
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        leatherDAO.deleteByIds(list);
    }

    @Override
    public List<Leather> queryByBrand(Pager pager, Leather leather) {
        return leatherDAO.queryByBrand(pager, leather);
    }

    @Override
    public int countByBrand(Leather leather) {
        return leatherDAO.countByBrand(leather);
    }

    @Override
    public List<Leather> queryBy12(int start, int over) {
        return leatherDAO.queryBy12(start, over);
    }

    @Override
    public List<Leather> queryByPrice(Pager pager, Leather leather) {
        return leatherDAO.queryByPrice(pager, leather);
    }

    @Override
    public int countByPrice(Leather leather) {
        return leatherDAO.countByPrice(leather);
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
