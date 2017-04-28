package com.watch.service;

import com.watch.bean.Core;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.BrandDAO;
import com.watch.dao.CoreDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class CoreServiceImpl implements CoreService{

    @Resource
    private CoreDAO coreDAO;


    @Override
    public List<Core> queryAll() {
        return coreDAO.queryAll();
    }

    @Override
    public Core queryById(Serializable id) {
        return coreDAO.queryById(id);
    }

    @Override
    public void add(Core core) {
        coreDAO.add(core);
    }

    @Override
    public void update(Core core) {
        coreDAO.update(core);
    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public Pager4EasyUI<Core> queryByPagerAndCriteria(Pager4EasyUI<Core> pager, Core core) {
        List<Core> cores = coreDAO.queryByPagerAndCriteria(pager, core);
        pager.setRows(cores);
        pager.setTotal(coreDAO.countByCriteria(core));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        coreDAO.deleteByIds(list);
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
