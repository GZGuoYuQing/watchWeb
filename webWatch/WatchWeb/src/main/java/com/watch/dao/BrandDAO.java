package com.watch.dao;

import com.watch.bean.Brand;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDAO extends BaseDAO<Brand> {

    public List<Brand> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Brand> pager, @Param("brand") Brand brand);
    /*
* 批量删除
* */
    public void deleteByIds(List<String> list);

    public Brand queryByDes(String des);
}
