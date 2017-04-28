package com.watch.service;

import com.watch.bean.Forum;
import com.watch.common.bean.Pager;

import java.util.List;


public interface ForumService extends BaseService<Forum> {

    public void deleteByIds(String id);


    public List<Forum> queryByWatchDetails(Pager pager, String typeDes, String type);

    public int count(String typeDes, String type);

    public List<Forum> queryByTitleDes(Pager pager, Forum forum);

    public int countByTitleDes(Forum forum);

    /*
    * 根据款式查询所有帖子并分页
    * */

    public List<Forum> queryByType(Pager pager, String type);

    public int countByType(String type);

    public void updateImg(Forum forum);

    public List<Forum> queryByPrice(Pager pager, Forum forum);

    public int countByPrice(Forum forum);

    public List<Forum> queryByAll(Pager pager);
    public List<Forum> queryByMB();
    public List<Forum> queryByPP();
    public int queryByCount();

}
