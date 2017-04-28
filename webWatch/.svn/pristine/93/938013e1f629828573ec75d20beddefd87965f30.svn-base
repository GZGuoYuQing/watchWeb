package com.watch.service;

import com.watch.bean.Forum;
import com.watch.bean.Watch;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.dao.ForumDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class ForumServiceImpl implements ForumService{

    @Resource
    private ForumDAO forumDAO;

    @Override
    public List<Forum> queryAll() {
        return forumDAO.queryAll();
    }

    @Override
    public Forum queryById(Serializable id) {
        return forumDAO.queryById(id);
    }

    @Override
    public void add(Forum forum) {
        forumDAO.add(forum);
    }

    @Override
    public void update(Forum forum) {
        forumDAO.update(forum);
    }

    @Override
    public void deleteById(Serializable id) {
        forumDAO.deleteById(id);
    }

    @Override
    public Pager4EasyUI<Forum> queryByPagerAndCriteria(Pager4EasyUI<Forum> pager, Forum forum) {
        List<Forum> forums = forumDAO.queryByPagerAndCriteria(pager,forum);
        pager.setRows(forums);
        pager.setTotal(forumDAO.countByCriteria(forum));
        return pager;
    }

    @Override
    public void deleteByIds(String id) {
        List<String> list = getList(id);
        forumDAO.deleteByIds(list);
    }


    @Override
    public List<Forum> queryByWatchDetails(Pager pager, String typeDes, String type) {
        return forumDAO.queryByWatchDetails(pager,typeDes,type);
    }

    @Override
    public int count(String typeDes, String type) {
        return forumDAO.count(typeDes,type);
    }

    @Override
    public List<Forum> queryByTitleDes(Pager pager, Forum forum) {
        return forumDAO.queryByTitleDes(pager,forum);
    }

    @Override
    public int countByTitleDes(Forum forum) {
        return forumDAO.countByTitleDes(forum);
    }

    @Override
    public List<Forum> queryByType(Pager pager, String type) {
        return forumDAO.queryByType(pager,type);
    }

    @Override
    public int countByType(String type) {
        return forumDAO.countByType(type);
    }

    @Override
    public void updateImg(Forum forum) {
        forumDAO.updateImg(forum);
    }

    @Override
    public List<Forum> queryByPrice(Pager pager, Forum forum) {
        return forumDAO.queryByPrice(pager,forum);
    }

    @Override
    public int countByPrice(Forum forum) {
        return forumDAO.countByPrice(forum);
    }

    @Override
    public List<Forum> queryByAll(Pager pager) {
        return forumDAO.queryByAll(pager);
    }

    @Override
    public List<Forum> queryByMB() {
        return forumDAO.queryByMB();
    }

    @Override
    public List<Forum> queryByPP() {
        return forumDAO.queryByPP();
    }

    @Override
    public int queryByCount() {
        return forumDAO.queryByCount();
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
