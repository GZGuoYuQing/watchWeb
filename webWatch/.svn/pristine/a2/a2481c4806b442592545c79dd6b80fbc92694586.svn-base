package com.watch.dao;

import com.watch.bean.Core;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoreDAO extends BaseDAO<Core> {
    public List<Core> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Core> pager, @Param("core") Core core);
    /*
* 批量删除
* */
    public void deleteByIds(List<String> list);
}
