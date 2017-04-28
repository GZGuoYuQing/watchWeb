package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.bean.Brand;
import com.watch.bean.Core;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.BrandService;
import com.watch.service.CoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao-kang on 2017/3/21.
 */

@Controller
@RequestMapping("/core")
public class CoreController {

    @Resource
    private CoreService coreService;

    /***
     * 进入机芯管理页面
     */
    @RequestMapping(value = "core_page",method = RequestMethod.GET)
    public String redirectPage(HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
        return "admin-page/core-page";
        }else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有品牌
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Core> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Core> pager = new Pager4EasyUI<Core>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Core core = new Core();
        pager = coreService.queryByPagerAndCriteria(pager,core);
        return pager;
    }

    /***
     * 添加品牌
     */
    @ResponseBody
    @RequestMapping(value="add_core",method = RequestMethod.POST)
    public ControllerResult addCore(Core core){
        coreService.add(core);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_core",method = RequestMethod.POST)
    public ControllerResult updateWatch(Core core){
        coreService.update(core);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        coreService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }


    /*
    * 下拉列表显示所有品牌
    * */
    @ResponseBody
    @RequestMapping(value = "query_core",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> Core(){
        List<Core> list = coreService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Core core: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(core.getId()));
            combox.setText(core.getDes());

            request.add(combox);
        }
        return request;
    }
}
