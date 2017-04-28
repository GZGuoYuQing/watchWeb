package com.watch.service;

import com.watch.bean.Watch;
import com.watch.common.bean.Pager;

import java.util.List;

/**
 * Created by xiao-kang on 2017/3/21.
 */
public interface WatchService extends BaseService<Watch> {

    public void deleteByIds(String id);

    public List<Watch> queryBy12(int start , int over);

    public List<Watch> queryByWatchDetails(Pager pager, String typeDes, String type);

    public int count(String typeDes, String type);

    public List<Watch> queryByTitleDes(Pager pager, Watch watch);

    public int countByTitleDes(Watch watch);

    /*
    * 根据款式查询所有手表并分页
    * */

    public List<Watch> queryByType(Pager pager,String type);

    public int countByType(String type);

    public void updateImg(Watch watch);


    public List<Watch> queryByPrice(Pager pager,Watch watch);

    public int countByPrice(Watch watch);

    public List<Watch> queryByTable(Pager pager, Watch watch);

    public int countByTable(Watch watch);

}
