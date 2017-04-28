package com.watch.dao;

import com.watch.bean.Admin;
import com.watch.common.bean.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiao-kang on 2017/3/21.
 */
@Repository
public interface AdminDAO extends BaseDAO<Admin> {

    public List<Admin> queryByPagerAndCriteria(@Param("pager") Pager4EasyUI<Admin> pager, @Param("admin") Admin admin);
    public Admin Login(Admin admin);

    public Admin queryName(String name);

    /*
* 批量删除
* */
    public void deleteByIds(List<String> list);
}
