package com.watch.service;

import com.watch.bean.Core;
import com.watch.bean.Style;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.CoreDAO;
import com.watch.dao.StyleDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class StyleServiceImpl implements StyleService{

    @Resource
    private StyleDAO styleDAO;

    @Override
    public List<Style> queryAll() {
        return styleDAO.queryAll();
    }

    @Override
    public Style queryById(Serializable id) {
        return styleDAO.queryById(id);
    }

    @Override
    public void add(Style style) {
        styleDAO.add(style);
    }

    @Override
    public void update(Style style) {
        styleDAO.update(style);
    }

    @Override
    public void deleteById(Serializable id) {
    }

    @Override
    public Pager4EasyUI<Style> queryByPagerAndCriteria(Pager4EasyUI<Style> pager, Style style) {
        List<Style> styles = styleDAO.queryByPagerAndCriteria(pager, style);
        pager.setRows(styles);
        pager.setTotal(styleDAO.countByCriteria(style));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        styleDAO.deleteByIds(list);
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
