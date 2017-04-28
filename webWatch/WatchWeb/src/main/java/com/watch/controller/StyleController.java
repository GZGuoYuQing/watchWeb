package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.bean.Style;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.StyleService;
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
@RequestMapping("/style")
public class StyleController {

    @Resource
    private StyleService styleService;

    /***
     * 进入风格管理页面
     */
    @RequestMapping(value = "style_page",method = RequestMethod.GET)
    public String showBrand(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/style-page";
        }else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有风格
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Style> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Style> pager = new Pager4EasyUI<Style>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Style style = new Style();
        pager = styleService.queryByPagerAndCriteria(pager,style);
        return pager;
    }

    /***
     * 添加风格
     */
    @ResponseBody
    @RequestMapping(value="add_style",method = RequestMethod.POST)
    public ControllerResult addStyle(Style style){
        styleService.add(style);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_style",method = RequestMethod.POST)
    public ControllerResult updateStyle(Style style){
        styleService.update(style);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        styleService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
    * 下拉列表显示所有风格
    * */
    @ResponseBody
    @RequestMapping(value = "query_style",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> style(){
        List<Style> list = styleService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Style style: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(style.getId()));
            combox.setText(style.getDes());

            request.add(combox);
        }
        return request;
    }


}
