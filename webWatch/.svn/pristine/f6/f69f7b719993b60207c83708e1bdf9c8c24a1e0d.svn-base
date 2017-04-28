package com.watch.service;

import com.watch.bean.Shose;
import com.watch.common.bean.Pager;

import java.util.List;


public interface ShoseService extends BaseService<Shose> {

    /*
* 更新表图片
* */
    public void updateImg(Shose shose);

    /*
 * 批量删除
 * */
    public void deleteByIds(String id);

    /*
* 根据品牌查询鞋子并分页
*
* */
    public List<Shose> queryByBrand(Pager pager, Shose shose);
    public int countByBrand(Shose shose);

    /*
    * 查询前XX条数据
    * */
    public List<Shose> queryBy12(int start, int over);

    /***
     * 右边导航栏分页查询鞋子价格
     */

    public List<Shose> queryByPrice(Pager pager,Shose shose);

    public int countByPrice(Shose shose);

}
