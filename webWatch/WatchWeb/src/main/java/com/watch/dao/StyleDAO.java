package com.watch.dao;

import com.watch.bean.Style;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StyleDAO extends BaseDAO<Style> {

    public List<Style> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Style> pager, @Param("brand") Style Style);

    public void deleteByIds(List<String> list);

}
