package com.watch.service;

import com.watch.bean.Watch;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.WatchDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao-kang on 2017/3/21.
 */
@Service
public class WatchServiceImpl implements WatchService {

    @Resource
    private WatchDAO watchDAO;

    @Override
    public List<Watch> queryAll() {
        return watchDAO.queryAll();
    }

    @Override
    public Watch queryById(Serializable id) {
        return watchDAO.queryById(id);
    }

    @Override
    public void add(Watch watch) {
        watchDAO.add(watch);
    }

    @Override
    public void update(Watch watch) {
        watchDAO.update(watch);
    }

    @Override
    public void deleteById(Serializable id) {
        watchDAO.deleteById(id);
    }

    @Override
    public Pager4EasyUI<Watch> queryByPagerAndCriteria(Pager4EasyUI<Watch> pager, Watch watch) {
        List<Watch> watches = watchDAO.queryByPagerAndCriteria(pager,watch);
        pager.setRows(watches);
        pager.setTotal(watchDAO.countByCriteria(watch));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        watchDAO.deleteByIds(list);
    }

    @Override
    public List<Watch> queryBy12(int start, int over) {
        return watchDAO.queryBy12(start,over);
    }

    @Override
    public List<Watch> queryByWatchDetails(Pager pager, String typeDes, String type) {
        return watchDAO.queryByWatchDetails(pager,typeDes,type);
    }

    @Override
    public int count(String typeDes, String type) {
        return watchDAO.count(typeDes,type);
    }

    @Override
    public List<Watch> queryByTitleDes(Pager pager, Watch watch) {
        return watchDAO.queryByTitleDes(pager,watch);
    }

    @Override
    public int countByTitleDes(Watch watch) {
        return watchDAO.countByTitleDes(watch);
    }

    @Override
    public List<Watch> queryByType(Pager pager, String type) {
        return watchDAO.queryByType(pager,type);
    }

    @Override
    public int countByType(String type) {
        return watchDAO.countByType(type);
    }

    @Override
    public void updateImg(Watch watch) {
        watchDAO.updateImg(watch);
    }

    @Override
    public List<Watch> queryByPrice(Pager pager, Watch watch) {
        return watchDAO.queryByPrice(pager,watch);
    }

    @Override
    public int countByPrice(Watch watch) {
        return watchDAO.countByPrice(watch);
    }

    @Override
    public List<Watch> queryByTable(Pager pager, Watch watch) {
        return watchDAO.queryByTable(pager,watch);
    }

    @Override
    public int countByTable(Watch watch) {
        return watchDAO.countByTable(watch);
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
