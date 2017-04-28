package com.watch.dao;

import com.watch.bean.Type;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeDAO extends BaseDAO<Type> {
    public Type quryByDes(String des);

    public List<Type> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Type> pager, @Param("type") Type type);

    public void deleteByIds(List<String> list);
}
