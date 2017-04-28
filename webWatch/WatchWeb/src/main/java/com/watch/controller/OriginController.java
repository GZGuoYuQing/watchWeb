package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.bean.Origin;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.OriginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/origin")
public class OriginController {

    @Resource
    private OriginService originService;


    /***
     * 进入产地管理页面
     */
    @RequestMapping(value = "origin_page",method = RequestMethod.GET)
    public String showOrigin(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/origin-page";
        }else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有产地
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Origin> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Origin> pager = new Pager4EasyUI<Origin>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Origin origin = new Origin();
        pager = originService.queryByPagerAndCriteria(pager,origin);
        return pager;
    }

    /***
     * 添加产地
     */
    @ResponseBody
    @RequestMapping(value="add_origin",method = RequestMethod.POST)
    public ControllerResult addOrigin(Origin origin){
        originService.add(origin);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_origin",method = RequestMethod.POST)
    public ControllerResult updateOrigin(Origin origin){
        originService.update(origin);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        originService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
    * 下拉列表显示所有产地
    * */
    @ResponseBody
    @RequestMapping(value = "query_origin",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> origin(){
        List<Origin> list = originService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Origin origin: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(origin.getId()));
            combox.setText(origin.getDes());
            request.add(combox);
        }
        return request;
    }
}
