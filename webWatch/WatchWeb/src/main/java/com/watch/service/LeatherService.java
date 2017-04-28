package com.watch.service;

import com.watch.bean.Leather;
import com.watch.common.bean.Pager;

import java.util.List;


public interface LeatherService extends BaseService<Leather> {

    /*
* 更新表图片
* */
    public void updateImg(Leather leather);

    /*
 * 批量删除
 * */
    public void deleteByIds(String id);

    /*
* 根据品牌查询鞋子并分页
*
* */
    public List<Leather> queryByBrand(Pager pager, Leather leather);
    public int countByBrand(Leather leather);

    /*
     * 查询前XX条数据
     * */
    public List<Leather> queryBy12(int start, int over);

    /***
     * 右边导航栏分页查询鞋子价格
     */
    public List<Leather> queryByPrice(Pager pager,Leather leather);
    public int countByPrice(Leather leather);
}
