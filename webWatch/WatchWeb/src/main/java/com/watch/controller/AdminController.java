package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.EncryptUtil;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JangoGuo on 2017/3/20.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    /***
     * 管理员登入入口
    @RequestMapping(value = "admin-login",method = RequestMethod.GET)
    public String redirectLogin(Model model) {
        return "/admin-page/admin-login";
    }
     */

    /**
     * 用户退出登陆*/
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public ModelAndView logOut(Model model, HttpSession session) {
        Admin ad = (Admin)session.getAttribute("admin");
        session.removeAttribute("admin");
        ModelAndView mv = new ModelAndView("admin-page/admin-login");
        return mv;
    }


    /***
     * 后台入口
     */
    @RequestMapping(value = "admin-index",method = RequestMethod.GET)
    public String redirectBackstage(Model model, HttpSession session) {
        Admin ad = (Admin)session.getAttribute("admin");
        if (ad != null) {
            return "admin-page/admin";
        } else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 进入管理员管理页面
     */
    @RequestMapping(value = "admin-page",method = RequestMethod.GET)
    public String redirectPage(Model model,HttpSession session) {
        Admin ad = (Admin)session.getAttribute("admin");
        if (ad != null) {
            return "admin-page/admin-page";
        } else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有管理员
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Admin> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Admin> pager = new Pager4EasyUI<Admin>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Admin admin = new Admin();
        pager = adminService.queryByPagerAndCriteria(pager,admin);
        return pager;
    }

    @ResponseBody
    @RequestMapping(value="add_admin",method = RequestMethod.POST)
    public ControllerResult addWatch(Admin admin){
        admin.setPassword(EncryptUtil.encrypt(admin.getPassword()));
        adminService.add(admin);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_admin",method = RequestMethod.POST)
    public ControllerResult updateWatch(Admin admin){
        admin.setPassword(EncryptUtil.encrypt(admin.getPassword()));
        adminService.update(admin);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        adminService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
* 下拉列表显示所有用户
* */
    @ResponseBody
    @RequestMapping(value = "query_name",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> admin(){
        List<Admin> list = adminService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Admin admin: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(admin.getId()));
            combox.setText(admin.getName());
            request.add(combox);
        }
        return request;
    }





}
