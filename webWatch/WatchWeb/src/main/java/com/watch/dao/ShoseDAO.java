package com.watch.dao;

import com.watch.bean.Shose;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoseDAO extends BaseDAO<Shose>{

    public List<Shose> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Shose> pager, @Param("shose") Shose shose);

    /*
   * 更新表图片
   * */
    public void updateImg(Shose shose);

    /*
 * 批量删除
 * */
    public void deleteByIds(List<String> list);

    /*
    * 根据品牌查询鞋子并分页
    *
    * */
    public List<Shose> queryByBrand(@Param("pager")Pager pager, @Param("shose") Shose shose);
    public int countByBrand(Shose shose);

        /*
    * 查询前XX条数据
    * */
    public List<Shose> queryBy12(@Param("start") int start, @Param("over") int over);

        /*
    * 根据款式品牌和价格区间查询鞋子并分页 右边导航栏
    *
    * */
    public List<Shose> queryByPrice(@Param("pager")Pager pager,@Param("shose") Shose shose);
    public int countByPrice(Shose shose);
}
