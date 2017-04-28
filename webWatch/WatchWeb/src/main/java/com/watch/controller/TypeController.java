package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.bean.Core;
import com.watch.bean.Type;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.TypeService;
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
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    /***
     * 进入管理页面
     */
    @RequestMapping(value = "type_page",method = RequestMethod.GET)
    public String showType(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/type-page";
        }else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有品牌
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Type> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Type> pager = new Pager4EasyUI<Type>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Type type = new Type();
        pager = typeService.queryByPagerAndCriteria(pager,type);
        return pager;
    }

    /***
     * 添加品牌
     */
    @ResponseBody
    @RequestMapping(value="add_type",method = RequestMethod.POST)
    public ControllerResult addType(Type type){
        typeService.add(type);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_type",method = RequestMethod.POST)
    public ControllerResult updateType(Type type){
        typeService.update(type);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        typeService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }
    /*
    * 下拉列表显示所有类型
    * */
    @ResponseBody
    @RequestMapping(value = "query_type",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> Type(){
        List<Type> list = typeService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Type type: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(type.getId()));
            combox.setText(type.getDes());
            request.add(combox);
        }
        return request;
    }
}
