package com.watch.controller;

import ch.qos.logback.classic.Logger;
import com.watch.bean.*;
import com.watch.common.Constants;
import com.watch.common.Methods;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.BrandService;
import com.watch.service.ShoseService;
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
@RequestMapping("/shose")
public class ShoseController {

    private Logger logger = (Logger) LoggerFactory.getLogger(ShoseController.class);

    @Resource
    private ShoseService shoseService;

    @Resource
    private BrandService brandService;

    /**
     * 查询手表列表*/
    @RequestMapping(value = "product/{brand}",method = RequestMethod.GET)
    public ModelAndView redirectShose(@PathVariable("brand")String brands, HttpServletRequest req) {
        logger.info("根据品牌查询鞋子");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        Shose shose = new Shose();
        if(brands != null && !brands.equals("")){
            if(!brands.equals("all")){
                Brand brand = brandService.queryByDes(brands);
                shose.setBrandId(brand.getId());
            }
        }
        int total = shoseService.countByBrand(shose);
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
        List<Shose> shoses = shoseService.queryByBrand(pager,shose);
        ModelAndView mav = new ModelAndView("watch/shosePage");
        mav.addObject("shoses", shoses);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("brand",brands);
        mav.addObject("check","1");
        return mav;
    }

    /**
     * 查看手表详情*/
    @RequestMapping(value = "details/{id}",method = RequestMethod.GET)
    public ModelAndView redirectDetails(@PathVariable("id")int id) {
        logger.info("根据手表ID查询手表");
        Shose shose = shoseService.queryById(id);
        List<Shose> shoses = shoseService.queryBy12(0,3);
        ModelAndView mav = new ModelAndView("watch/sho-details");
        mav.addObject("shoses",shoses);
        mav.addObject("shose",shose);
        return mav;
    }


    /**
     * 根据款式/品牌/价格区间查询鞋子并分页
     *
     * */
    @RequestMapping(value = "queryByPrices",method = RequestMethod.GET)
    public ModelAndView redirectWatchPrice(@Param("type") String type, @Param("des") String des ,@Param("prices") String prices, HttpServletRequest req) {
        logger.info("根据款式/品牌/价格区间查询鞋子并分页");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        Shose shose = new Shose();
        if(des != null && !des.equals("")){
            Brand brand = brandService.queryByDes(des);
            shose.setBrandId(brand.getId());
        }
        shose.setPrices(prices);
        shose.setType(type);
        int total = shoseService.countByPrice(shose);
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
        List<Shose> shoses = shoseService.queryByPrice(pager,shose);
        ModelAndView mav = new ModelAndView("watch/shosePage");
        mav.addObject("shoses", shoses);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("type",type);
        mav.addObject("des",des);
        mav.addObject("prices",prices);
        mav.addObject("check","4");
        return mav;
    }

    /**
     * 后台鞋子管理页面*/
    @RequestMapping(value = "shose_page",method = RequestMethod.GET)
    public String showshose(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/shose-page";
        }else {
            return "admin-page/admin-login";
        }
    }



    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Shose> queryPager(@Param("page")String page, @Param("rows")String rows, @Param("brand") String brand, @Param("title") String title){
        logger.info("分页查询所有鞋子");
        Pager4EasyUI<Shose> pager = new Pager4EasyUI<Shose>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Shose shose = new Shose();
        if(title != null && !title.equals("") || brand != null && !brand.equals("")){
            shose.setTitle(title);
            shose.setBrandId(Integer.valueOf(brand));
        }
        pager = shoseService.queryByPagerAndCriteria(pager,shose);
        return pager;
    }


    @ResponseBody
    @RequestMapping(value="add_shose",method = RequestMethod.POST)
    public ControllerResult addshose(MultipartFile videofile, Shose shose, @RequestParam MultipartFile[] files, MultipartFile fileImg){
        logger.info("添加鞋子");
        try {
            for(int i = 0, len =  files.length; i < len;i++){
                MultipartFile file = files[i];
                String fileName = Methods.createName(file.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!file.isEmpty()){
                    file.transferTo(new File(path));
                    if(i == 0){
                        shose.setImage1(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 1){
                        shose.setImage2(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 2){
                        shose.setImage3(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 3){
                        shose.setImage4(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 4){
                        shose.setImage5(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 5){
                        shose.setImage6(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 6){
                        shose.setImage7(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 7){
                        shose.setImage8(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }
                }
            }
            if(videofile != null){
                String fileName = Methods.createName(videofile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videofile.isEmpty()){
                    videofile.transferTo(new File(path));
                    shose.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }

            if(fileImg != null){
                String fileName = Methods.createName(fileImg.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!fileImg.isEmpty()){
                    fileImg.transferTo(new File(path));
                    shose.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                }
            }

        }catch (IOException e){

        }
        getComboxId(shose);
        shoseService.add(shose);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_shose",method = RequestMethod.POST)
    public ControllerResult updateshose(Shose shose,MultipartFile videofile,String video){
        logger.info("更新鞋子基本信息");
        try {
            if(videofile != null){
                String fileName = Methods.createName(videofile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videofile.isEmpty()){
                    videofile.transferTo(new File(path));
                    shose.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }else{
                shose.setVideo(video);
            }

        }catch (IOException e){

        }
        getComboxId(shose);
        shoseService.update(shose);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="update_shoseImg",method = RequestMethod.POST)
    public ControllerResult updateWatchImg(Shose shose,MultipartFile file1,MultipartFile file2,MultipartFile file3,
                                           MultipartFile file4,MultipartFile file5,MultipartFile file6,MultipartFile file7,
                                           MultipartFile file8,MultipartFile file9){
        logger.info("更新鞋子图片");
        try {
            Shose shose1 = shoseService.queryById(shose.getId());
            if(file1 != null){
                String fileName = Methods.createName(file1.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file1.transferTo(new File(path));
                shose.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage(shose1.getImage());
            }
            if(file2 != null){
                String fileName = Methods.createName(file2.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file2.transferTo(new File(path));
                shose.setImage1(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage1(shose1.getImage1());
            }
            if(file3 != null){
                String fileName = Methods.createName(file3.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file3.transferTo(new File(path));
                shose.setImage2(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage2(shose1.getImage2());
            }

            if(file4 != null){
                String fileName = Methods.createName(file4.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file4.transferTo(new File(path));
                shose.setImage3(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage3(shose1.getImage3());
            }

            if(file5 != null){
                String fileName = Methods.createName(file5.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file5.transferTo(new File(path));
                shose.setImage4(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage4(shose1.getImage4());
            }

            if(file6 != null){
                String fileName = Methods.createName(file6.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file6.transferTo(new File(path));
                shose.setImage5(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage5(shose1.getImage5());
            }

            if(file7 != null){
                String fileName = Methods.createName(file7.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file7.transferTo(new File(path));
                shose.setImage6(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage6(shose1.getImage6());
            }
            if(file8 != null){
                String fileName = Methods.createName(file8.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file8.transferTo(new File(path));
                shose.setImage7(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage7(shose1.getImage7());
            }
            if(file9 != null){
                String fileName = Methods.createName(file9.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file9.transferTo(new File(path));
                shose.setImage8(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                shose.setImage8(shose1.getImage8());
            }

        }catch (IOException e){

        }
        shoseService.updateImg(shose);
        return ControllerResult.getSuccessResult("更新成功");
    }



    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        logger.info("删除手表");
        shoseService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

    /*
  * 根据页面的comboxID设置到
  * */
    public void getComboxId(Shose shose){
        Material material = new Material();
        material.setId(shose.getMaterial().getId());
        Origin origin = new Origin();
        origin.setId(shose.getOrigin().getId());
        Brand brand = new Brand();
        brand.setId(shose.getBrand().getId());
        Style style = new Style();
        style.setId(shose.getStyle().getId());
        shose.setStyle(style);
        shose.setBrand(brand);
        shose.setOrigin(origin);
        shose.setMaterial(material);
    }
}
