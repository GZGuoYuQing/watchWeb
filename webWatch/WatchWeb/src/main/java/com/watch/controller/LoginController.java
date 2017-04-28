package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.common.bean.EncryptUtil;
import com.watch.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by JangoGuo on 2017/3/21.
 */
@Controller
@RequestMapping("/login")
public class LoginController  {

    @Resource
    private AdminService adminService;

    /**
     * 管理员登陆验证*/
    @RequestMapping(value="login-admin",method = RequestMethod.POST)
    public String LoginAdmin(Model model ,HttpSession session, Admin admin){
        Admin ad = (Admin)session.getAttribute("admin");
        if (ad != null) {
            return "admin-page/admin";
        } else {
            admin.setPassword(EncryptUtil.encrypt(admin.getPassword()));
            admin = adminService.Login(admin);
            if (admin != null) {
                session.setAttribute("admin",admin);
                return "admin-page/admin";
            } else {
                return "admin-page/admin-login";
            }
        }

    }


    /***
     * 管理员登入页面
     */
     @RequestMapping(value = "login",method = RequestMethod.GET)
     public String redirectLogin(Model model) {
            return "admin-page/admin-login";
     }

}

























