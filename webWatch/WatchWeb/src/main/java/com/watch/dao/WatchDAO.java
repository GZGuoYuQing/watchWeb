package com.watch.dao;

import com.watch.bean.Watch;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WatchDAO extends BaseDAO<Watch> {
    public List<Watch> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Watch> pager, @Param("watch") Watch watch);

    /*
    * 批量删除
    * */
    public void deleteByIds(List<String> list);

    /*
    * 查询前十六条数据
    * */

    public List<Watch> queryBy12(@Param("start") int start, @Param("over") int over);

    /*
    * 根据品牌和款式查询手表并分页
    * */

    public List<Watch> queryByWatchDetails(@Param("pager")Pager pager, @Param("styleDes") String typeDes, @Param("type") String type);

    public int count(@Param("styleDes") String typeDes, @Param("type") String type);

     /*
    * 根据标题和描述模糊查询手表并分页
    * */

    public List<Watch> queryByTitleDes(@Param("pager")Pager pager, @Param("watch") Watch watch);

    public int countByTitleDes(Watch watch);

    /*
    * 根据款式查询所有手表并分页
    * */

    public List<Watch> queryByType(@Param("pager")Pager pager, @Param("type") String type);

    public int countByType(String type);

    /*
    * 更新表图片
    * */
    public void updateImg(Watch watch);


    /*
    * 根据款式品牌和价格区间查询手表并分页
    *
    * */
    public List<Watch> queryByPrice(@Param("pager")Pager pager,@Param("watch") Watch watch);

    public int countByPrice(Watch watch);

    /*
    * 根据标签查询手表并分页
    *
    * */
    public List<Watch> queryByTable(@Param("pager")Pager pager,@Param("watch") Watch watch);

    public int countByTable(Watch watch);


}
