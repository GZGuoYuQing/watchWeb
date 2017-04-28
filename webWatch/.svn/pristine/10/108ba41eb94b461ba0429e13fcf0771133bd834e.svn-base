package com.watch.dao;

import com.watch.bean.Forum;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ForumDAO extends BaseDAO<Forum> {
    public List<Forum> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Forum> pager, @Param("forum") Forum forum);

    /*
    * 批量删除
    * */
    public void deleteByIds(List<String> list);


    /*
    * 根据品牌和款式查询手表并分页
    * */

    public List<Forum> queryByWatchDetails(@Param("pager") Pager pager, @Param("styleDes") String typeDes, @Param("type") String type);

    public int count(@Param("styleDes") String typeDes, @Param("type") String type);

     /*
    * 根据标题和描述模糊查询手表并分页
    * */

    public List<Forum> queryByTitleDes(@Param("pager") Pager pager, @Param("forum") Forum forum);

    public int countByTitleDes(Forum forum);

    /*
    * 根据款式查询所有手表并分页
    * */

    public List<Forum> queryByType(@Param("pager") Pager pager, @Param("type") String type);

    public int countByType(String type);

    /*
    * 更新表图片
    * */
    public void updateImg(Forum forum);


    /*
    * 根据款式品牌和价格区间查询手表并分页
    *
    * */
    public List<Forum> queryByPrice(@Param("pager") Pager pager, @Param("forum") Forum Forum);

    public int countByPrice(Forum forum);

    public List<Forum> queryByAll(@Param("pager") Pager pager);
    public List<Forum> queryByMB();
    public List<Forum> queryByPP();
    public int queryByCount();
}
