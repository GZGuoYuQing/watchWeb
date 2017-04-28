package com.watch.dao;

import com.watch.bean.Leather;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LeatherDAO extends BaseDAO<Leather>{

    public List<Leather> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Leather> pager, @Param("leather") Leather leather);

    /*
   * 更新表图片
   * */
    public void updateImg(Leather leather);

    /*
 * 批量删除
 * */
    public void deleteByIds(List<String> list);

    /*
    * 根据品牌查询鞋子并分页
    *
    * */
    public List<Leather> queryByBrand(@Param("pager") Pager pager, @Param("leather") Leather leather);
    public int countByBrand(Leather leather);

        /*
    * 查询前XX条数据
    * */
    public List<Leather> queryBy12(@Param("start") int start, @Param("over") int over);

        /*
    * 根据款式品牌和价格区间查询鞋子并分页 右边导航栏
    *
    * */
    public List<Leather> queryByPrice(@Param("pager")Pager pager,@Param("leather") Leather leather);
    public int countByPrice(Leather leather);
}
