package com.watch.controller;

import ch.qos.logback.classic.Logger;
import com.watch.bean.*;
import com.watch.common.Constants;
import com.watch.common.Methods;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.BrandService;
import com.watch.service.LeatherService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by xiao-kang on 2017/4/11.
 */
@Controller
@RequestMapping("/leather")
public class LeatherController {

    private Logger logger = (Logger) LoggerFactory.getLogger(LeatherController.class);

    @Resource
    private LeatherService leatherService;

    @Resource
    private BrandService brandService;

    /**
     * 前台查询皮具并分页列表*/
    @RequestMapping(value = "product/{brand}",method = RequestMethod.GET)
    public ModelAndView redirectleather(@PathVariable("brand")String brands, HttpServletRequest req) {
        logger.info("根据品牌查询皮具");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        Leather leather = new Leather();
        if(brands != null && !brands.equals("")){
            if(!brands.equals("all")){
                Brand brand = brandService.queryByDes(brands);
                leather.setBrandId(brand.getId());
            }
        }
        int total = leatherService.countByBrand(leather);
        int totalPage = (total % pageSize )== 0 ? total / pageSize :(total / pageSize +1);
        if(pageNoStr != null){
            try {
                pageNo = Integer.valueOf(pageNoStr);
                if(pageNo <= 0){
                    pageNo = 1;
                }else if(pageNo > totalPage){
                    pageNo = totalPage;
                }

            }catch (NumberFormatException e){
            }
        }
        Pager pager = new Pager(pageNo,pageSize,0);
        List<Leather> leathers = leatherService.queryByBrand(pager,leather);
        ModelAndView mav = new ModelAndView("watch/leatherPage");
        mav.addObject("leathers", leathers);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("brand",brands);
        mav.addObject("check","1");
        return mav;
    }

    /**
     * 前台查看皮具详情*/
    @RequestMapping(value = "details/{id}",method = RequestMethod.GET)
    public ModelAndView redirectDetails(@PathVariable("id")int id) {
        logger.info("根据皮具ID查询皮具");
        Leather leather = leatherService.queryById(id);
        List<Leather> leathers = leatherService.queryBy12(0,3);
        ModelAndView mav = new ModelAndView("watch/lea-details");
        mav.addObject("leathers",leathers);
        mav.addObject("leather",leather);
        return mav;
    }


    /**
     * 根据款式/品牌/价格区间查询鞋子并分页
     *
     * */
    @RequestMapping(value = "queryByPrices",method = RequestMethod.GET)
    public ModelAndView redirectLeatherPrice(@Param("type") String type, @Param("des") String des ,@Param("prices") String prices, HttpServletRequest req) {
        logger.info("根据款式/品牌/价格区间查询皮具并分页");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        Leather leather = new Leather();
        if(des != null && !des.equals("")){
            Brand brand = brandService.queryByDes(des);
            leather.setBrandId(brand.getId());
        }
        leather.setPrices(prices);
        leather.setType(type);
        int total = leatherService.countByPrice(leather);
        int totalPage = (total % pageSize )== 0 ? total / pageSize :(total / pageSize +1);
        if(pageNoStr != null){
            try {
                pageNo = Integer.valueOf(pageNoStr);
                if(pageNo <= 0){
                    pageNo = 1;
                }else if(pageNo > totalPage){
                    pageNo = totalPage;
                }

            }catch (NumberFormatException e){

            }
        }
        Pager pager = new Pager(pageNo,pageSize,0);
        List<Leather> leathers = leatherService.queryByPrice(pager,leather);
        ModelAndView mav = new ModelAndView("watch/leatherPage");
        mav.addObject("leathers", leathers);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("type",type);
        mav.addObject("des",des);
        mav.addObject("prices",prices);
        mav.addObject("check","4");
        return mav;
    }


    /**
     * 后台皮具管理页面*/
    @RequestMapping(value = "leather_page",method = RequestMethod.GET)
    public String showleather(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/leather-page";
        }else {
            return "admin-page/admin-login";
        }
    }



    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Leather> queryPager(@Param("page")String page, @Param("rows")String rows, @Param("brand") String brand, @Param("title") String title){
        logger.info("分页查询所有皮具");
        Pager4EasyUI<Leather> pager = new Pager4EasyUI<Leather>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Leather leather = new Leather();
        if(title != null && !title.equals("") || brand != null && !brand.equals("")){
            leather.setTitle(title);
            leather.setBrandId(Integer.valueOf(brand));
        }
        pager = leatherService.queryByPagerAndCriteria(pager,leather);
        return pager;
    }


    @ResponseBody
    @RequestMapping(value="add_leather",method = RequestMethod.POST)
    public ControllerResult addleather(MultipartFile videofile, Leather leather, @RequestParam MultipartFile[] files,MultipartFile fileImg){
        logger.info("添加皮具");
        try {
            for(int i = 0, len =  files.length; i < len;i++){
                MultipartFile file = files[i];
                String fileName = Methods.createName(file.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!file.isEmpty()){
                    file.transferTo(new File(path));
                    if(i == 0){
                        leather.setImage1(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 1){
                        leather.setImage2(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 2){
                        leather.setImage3(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 3){
                        leather.setImage4(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 4){
                        leather.setImage5(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 5){
                        leather.setImage6(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 6){
                        leather.setImage7(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 7){
                        leather.setImage8(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }
                }
            }
            if(videofile != null){
                String fileName = Methods.createName(videofile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videofile.isEmpty()){
                    videofile.transferTo(new File(path));
                    leather.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }

            if(fileImg != null){
                String fileName = Methods.createName(fileImg.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!fileImg.isEmpty()){
                    fileImg.transferTo(new File(path));
                    leather.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                }
            }
        }catch (IOException e){

        }
        getComboxId(leather);
        leatherService.add(leather);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_leather",method = RequestMethod.POST)
    public ControllerResult updateleather(Leather leather,MultipartFile videofile,String video){
        logger.info("更新皮具基本信息");
        try {
            if(videofile != null){
                String fileName = Methods.createName(videofile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videofile.isEmpty()){
                    videofile.transferTo(new File(path));
                    leather.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }else{
                leather.setVideo(video);
            }

        }catch (IOException e){

        }
        getComboxId(leather);
        leatherService.update(leather);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="update_leatherImg",method = RequestMethod.POST)
    public ControllerResult updateWatchImg(Leather leather,MultipartFile file1,MultipartFile file2,MultipartFile file3,
                                           MultipartFile file4,MultipartFile file5,MultipartFile file6,MultipartFile file7,
                                           MultipartFile file8,MultipartFile file9){
        logger.info("更新皮具图片");
        try {
            Leather leather1 = leatherService.queryById(leather.getId());
            if(file1 != null){
                String fileName = Methods.createName(file1.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file1.transferTo(new File(path));
                leather.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage(leather1.getImage());
            }
            if(file2 != null){
                String fileName = Methods.createName(file2.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file2.transferTo(new File(path));
                leather.setImage1(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage1(leather1.getImage1());
            }
            if(file3 != null){
                String fileName = Methods.createName(file3.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file3.transferTo(new File(path));
                leather.setImage2(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage2(leather1.getImage2());
            }

            if(file4 != null){
                String fileName = Methods.createName(file4.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file4.transferTo(new File(path));
                leather.setImage3(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage3(leather1.getImage3());
            }

            if(file5 != null){
                String fileName = Methods.createName(file5.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file5.transferTo(new File(path));
                leather.setImage4(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage4(leather1.getImage4());
            }

            if(file6 != null){
                String fileName = Methods.createName(file6.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file6.transferTo(new File(path));
                leather.setImage5(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage5(leather1.getImage5());
            }

            if(file7 != null){
                String fileName = Methods.createName(file7.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file7.transferTo(new File(path));
                leather.setImage6(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage6(leather1.getImage6());
            }
            if(file8 != null){
                String fileName = Methods.createName(file8.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file8.transferTo(new File(path));
                leather.setImage7(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage7(leather1.getImage7());
            }
            if(file9 != null){
                String fileName = Methods.createName(file9.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file9.transferTo(new File(path));
                leather.setImage8(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                leather.setImage8(leather1.getImage8());
            }

        }catch (IOException e){

        }
        leatherService.updateImg(leather);
        return ControllerResult.getSuccessResult("更新成功");
    }



    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        logger.info("删除手表");
        leatherService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
  * 根据页面的comboxID设置到
  * */
    public void getComboxId(Leather leather){
        Material material = new Material();
        material.setId(leather.getMaterial().getId());
        Origin origin = new Origin();
        origin.setId(leather.getOrigin().getId());
        Brand brand = new Brand();
        brand.setId(leather.getBrand().getId());
        Style style = new Style();
        style.setId(leather.getStyle().getId());
        leather.setStyle(style);
        leather.setBrand(brand);
        leather.setOrigin(origin);
        leather.setMaterial(material);
    }
}
