package com.watch.service;

import com.watch.bean.Forum;
import com.watch.bean.Type;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.TypeDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class TypeServiceImpl implements TypeService{

    @Resource
    private TypeDAO typeDAO;


    @Override
    public List<Type> queryAll() {
        return typeDAO.queryAll();
    }

    @Override
    public Type queryById(Serializable id) {
        return typeDAO.queryById(id);
    }

    @Override
    public void add(Type type) {
        typeDAO.add(type);
    }

    @Override
    public void update(Type type) {
    typeDAO.update(type);
    }

    @Override
    public void deleteById(Serializable id) {
    typeDAO.deleteById(id);
    }

    @Override
    public Pager4EasyUI<Type> queryByPagerAndCriteria(Pager4EasyUI<Type> pager, Type type) {
        List<Type> types =typeDAO.queryByPagerAndCriteria(pager, type);
        pager.setRows(types);
        pager.setTotal(typeDAO.countByCriteria(type));
        return pager;
    }

    @Override
    public Type queryByDes(String des) {
        return typeDAO.quryByDes(des);
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        typeDAO.deleteByIds(list);
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
