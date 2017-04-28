package com.watch.service;

import com.watch.bean.Core;
import com.watch.bean.Material;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.CoreDAO;
import com.watch.dao.MaterialDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class MaterialServiceImpl implements MaterialService{

    @Resource
    private MaterialDAO materialDAO;

    @Override
    public List<Material> queryAll() {
        return materialDAO.queryAll();
    }

    @Override
    public Material queryById(Serializable id) {
        return null;
    }

    @Override
    public void add(Material material) {
        materialDAO.add(material);
    }

    @Override
    public void update(Material material) {
        materialDAO.update(material);
    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public Pager4EasyUI<Material> queryByPagerAndCriteria(Pager4EasyUI<Material> pager, Material material) {
        List<Material> materials = materialDAO.queryByPagerAndCriteria(pager, material);
        pager.setRows(materials);
        pager.setTotal(materialDAO.countByCriteria(material));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        materialDAO.deleteByIds(list);
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
