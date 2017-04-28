package com.watch.dao;

import com.watch.bean.Material;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialDAO extends BaseDAO<Material> {

    public List<Material> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Material> pager, @Param("material") Material material);


    /*
* 批量删除
* */
    public void deleteByIds(List<String> list);

}
