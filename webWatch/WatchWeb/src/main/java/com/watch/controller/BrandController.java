package com.watch.controller;

import com.watch.bean.Admin;
import com.watch.bean.Brand;
import com.watch.common.bean.ComboBox4EasyUI;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.BrandService;
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
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /***
     * 进入品牌管理页面
     */
    @RequestMapping(value = "brand_page",method = RequestMethod.GET)
    public String showBrand(Model model, HttpSession session) {
        Admin ad = (Admin)session.getAttribute("admin");
        if (ad != null) {
            System.out.println("====================================================================测试");
            return "admin-page/brand-page";
        } else {
            return "admin-page/admin-login";
        }
    }

    /***
     * 显示所有品牌
     */
    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Brand> queryPager(@Param("page")String page, @Param("rows")String rows){
        Pager4EasyUI<Brand> pager = new Pager4EasyUI<Brand>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Brand brand = new Brand();
        pager = brandService.queryByPagerAndCriteria(pager,brand);
        return pager;
    }

    /***
     * 添加品牌
     */
    @ResponseBody
    @RequestMapping(value="add_brand",method = RequestMethod.POST)
    public ControllerResult addBrand(Brand brand){
        brandService.add(brand);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_brand",method = RequestMethod.POST)
    public ControllerResult updateWatch(Brand brand){
        brandService.update(brand);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        brandService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
    * 下拉列表显示所有品牌
    * */
    @ResponseBody
    @RequestMapping(value = "query_brand",method = RequestMethod.GET)
    public List<ComboBox4EasyUI> brand(){
        List<Brand> list = brandService.queryAll();
        List<ComboBox4EasyUI> request = new ArrayList<ComboBox4EasyUI>();
        for(Brand brand: list){
            ComboBox4EasyUI combox = new ComboBox4EasyUI();
            combox.setId(String.valueOf(brand.getId()));
            combox.setText(brand.getDes());

            request.add(combox);
        }
        return request;
    }


}
