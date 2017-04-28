package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.bean.Material;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.MaterialService;
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
@RequestMapping("/material")
public class MaterialController {

    @Resource
    private MaterialService materialService;


    /***
     * 进入材质管理页面
     */
    @RequestMapping(value = "material_page",method = RequestMethod.GET)
    public String showBrand(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/material-page";
        }else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有材质
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Material> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Material> pager = new Pager4EasyUI<Material>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Material material = new Material();
        pager = materialService.queryByPagerAndCriteria(pager,material);
        return pager;
    }

    /***
     * 添加品牌
     */
    @ResponseBody
    @RequestMapping(value="add_material",method = RequestMethod.POST)
    public ControllerResult addMaterial(Material material){
        materialService.add(material);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_material",method = RequestMethod.POST)
    public ControllerResult updateMaterial(Material material){
        materialService.update(material);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        materialService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
    * 下拉列表显示所有品牌
    * */
    @ResponseBody
    @RequestMapping(value = "query_material",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> material(){
        List<Material> list = materialService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Material material: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(material.getId()));
            combox.setText(material.getDes());
            request.add(combox);
        }
        return request;
    }
}
