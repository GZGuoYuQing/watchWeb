package com.watch.service;

import com.watch.bean.Admin;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.AdminDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyq on 2017/3/21.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminDAO adminDAO;


    @Override
    public List<Admin> queryAll() {
        return adminDAO.queryAll();
    }

    @Override
    public Admin queryById(Serializable id) {
        return adminDAO.queryById(id);
    }

    @Override
    public void add(Admin admin) {
        adminDAO.add(admin);
    }

    @Override
    public void update(Admin admin) {
        adminDAO.update(admin);
    }

    @Override
    public void deleteById(Serializable id) {
        adminDAO.deleteById(id);
    }

    @Override
    public Pager4EasyUI<Admin> queryByPagerAndCriteria(Pager4EasyUI<Admin> pager, Admin admin) {
        List<Admin> admins = adminDAO.queryByPagerAndCriteria(pager,admin);
        pager.setRows(admins);
        pager.setTotal(adminDAO.countByCriteria(admin));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        adminDAO.deleteByIds(list);
    }

    public List<String> getList(String id) {
        List<String> list = new ArrayList<String>();
        String[] str = id.split(",");
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }

    @Override
    public Admin Login(Admin admin) {
        return adminDAO.Login(admin);
    }

    @Override
    public Admin queryName(String name) {
        return adminDAO.queryName(name);
    }
}
