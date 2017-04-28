package com.watch.dao;

import com.watch.bean.Origin;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OriginDAO extends BaseDAO<Origin> {
    public List<Origin> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Origin> pager, @Param("origin") Origin origin);
    /*
* 批量删除
* */
    public void deleteByIds(List<String> list);
}
