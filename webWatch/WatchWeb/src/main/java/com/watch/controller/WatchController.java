package com.watch.controller;

import ch.qos.logback.classic.Logger;
import com.watch.bean.*;
import com.watch.common.Constants;
import com.watch.common.Methods;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.BrandService;
import com.watch.service.WatchService;
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
 * Created by Administrator on 2017/3/18 0018.
 */
@Controller
@RequestMapping("/watch")
public class WatchController {

    private Logger logger = (Logger) LoggerFactory.getLogger(WatchController.class);

    @Resource
    private WatchService watchService;

    @Resource
    private BrandService brandService;
    /**
     * 查询手表列表*/
    @RequestMapping(value = "products/{styleDes}/{type}",method = RequestMethod.GET)
    public ModelAndView redirectWatch(@PathVariable("styleDes")String styleDes, @PathVariable("type") String type, HttpServletRequest req) {
        logger.info("根据品牌和款式查询手表");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        int total = watchService.count(styleDes,type);
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
        List<Watch> watches = watchService.queryByWatchDetails(pager,styleDes,type);
        ModelAndView mav = new ModelAndView("watch/products");
        mav.addObject("watches", watches);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("type",type);
        mav.addObject("styleDes",styleDes);
        mav.addObject("check","1");
        return mav;
    }


    /**
     * 根据手表标题和描述和功能模糊查询手表列表*/
    @RequestMapping(value = "queryByTitleDes",method = RequestMethod.GET)
    public ModelAndView queryByTitleDes(@Param("value")String value , HttpServletRequest req) {
        logger.info("根据手表标题和描述和功能模糊查询手表");
        String pageNoStr = req.getParameter("page");
        Watch watch = new Watch();
        watch.setDes(value);
        watch.setTitle(value);
        watch.setFunction(value);
        int pageNo = 1;
        int pageSize = 9;
        int total = watchService.countByTitleDes(watch);
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
        List<Watch> watches = watchService.queryByTitleDes(pager,watch);
        ModelAndView mav = new ModelAndView("watch/products");
        mav.addObject("watches", watches);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("value",value);
        mav.addObject("check","2");
        return mav;
    }

    /**
     * 查询款式所有手表*/
    @RequestMapping(value = "productsType/{type}",method = RequestMethod.GET)
    public ModelAndView redirectWatchType(@PathVariable("type") String type, HttpServletRequest req) {
        logger.info("根据款式查询手表");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        int total = watchService.countByType(type);
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
        List<Watch> watches = watchService.queryByType(pager,type);
        ModelAndView mav = new ModelAndView("watch/products");
        mav.addObject("watches", watches);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("type",type);
        mav.addObject("check","3");
        return mav;
    }



    /**
     * 根据款式品牌和价格区间查询手表并分页
     *
     * */
    @RequestMapping(value = "queryByPrices",method = RequestMethod.GET)
    public ModelAndView redirectWatchPrice(@Param("type") String type, @Param("des") String des ,@Param("prices") String prices, HttpServletRequest req) {
        logger.info("根据款式品牌和价格区间查询手表并分页");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        Watch watch = new Watch();
        if(des != null && !des.equals("")){
            Brand brand = brandService.queryByDes(des);
            watch.setBrandId(brand.getId());
        }
        watch.setPrices(prices);
        watch.setType(type);
        int total = watchService.countByPrice(watch);
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
        List<Watch> watches = watchService.queryByPrice(pager,watch);
        ModelAndView mav = new ModelAndView("watch/products");
        mav.addObject("watches", watches);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("type",type);
        mav.addObject("des",des);
        mav.addObject("prices",prices);
        mav.addObject("check","4");
        return mav;
    }

    /**
     * 查询手表列表*/
    @RequestMapping(value = "productsBSO/{des}/{prices}",method = RequestMethod.GET)
    public ModelAndView redirectWatch1(@PathVariable("des")String des, @PathVariable("prices")String prices, HttpServletRequest req) {
        logger.info("根据品牌和标签查询手表");
        String pageNoStr = req.getParameter("page");
        int pageNo = 1;
        int pageSize = 9;
        Watch watch = new Watch();
        watch.setPrices(prices);
        if(des != null && !des.equals("")){
            if(!des.equals("all")){
                Brand brand = brandService.queryByDes(des);
                watch.setBrandId(brand.getId());
            }
        }
        int total = watchService.countByTable(watch);
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
        List<Watch> watches = watchService.queryByTable(pager,watch);
        ModelAndView mav = new ModelAndView("watch/products");
        mav.addObject("watches", watches);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        mav.addObject("des",des);
        mav.addObject("check","5");
        mav.addObject("prices",prices);
        return mav;
    }


    /**
     * 查看手表详情*/
    @RequestMapping(value = "details/{id}",method = RequestMethod.GET)
    public ModelAndView redirectDetails(@PathVariable("id")int id) {
        logger.info("根据手表ID查询手表");
        Watch watch = watchService.queryById(id);
        List<Watch> watchs = watchService.queryBy12(0,3);
        ModelAndView mav = new ModelAndView("watch/pro-details");
        mav.addObject("watchs",watchs);
        mav.addObject("watch",watch);
        return mav;
    }


    /**
     * 查看论坛详情*/
    @RequestMapping(value = "fontDetails",method = RequestMethod.GET)
    public String redirectFontDetails(Model model) {
        return "/watch/font-details";
    }


    /**
     * 后台手表管理页面*/
    @RequestMapping(value = "watch_page",method = RequestMethod.GET)
    public String showWatch(Model model, HttpSession session) {
        Admin ad = (Admin) session.getAttribute("admin");
        if(ad!=null){
            return "/admin-page/watch-all";
        }else {
            return "admin-page/admin-login";
        }
    }


    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Watch> queryPager(@Param("page")String page, @Param("rows")String rows, @Param("brand") String brand, @Param("title") String title){
        logger.info("分页查询所有手表");
        Pager4EasyUI<Watch> pager = new Pager4EasyUI<Watch>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Watch watch = new Watch();
        if(title != null && !title.equals("") || brand != null && !brand.equals("")){
            watch.setTitle(title);
            watch.setBrandId(Integer.valueOf(brand));
        }
        pager = watchService.queryByPagerAndCriteria(pager,watch);
        return pager;
    }

    @ResponseBody
    @RequestMapping(value="add_watch",method = RequestMethod.POST)
    public ControllerResult addWatch(MultipartFile videofile,Watch watch,@RequestParam MultipartFile[] files,MultipartFile fileImg){
        logger.info("添加手表");
        try {
            for(int i = 0, len =  files.length; i < len;i++){
                MultipartFile file = files[i];
                String fileName = Methods.createName(file.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!file.isEmpty()){
                    file.transferTo(new File(path));
                    if(i == 0){
                        watch.setImage1(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 1){
                        watch.setImage2(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 2){
                        watch.setImage3(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 3){
                        watch.setImage4(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 4){
                        watch.setImage5(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 5){
                        watch.setImage6(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 6){
                        watch.setImage7(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }else if(i == 7){
                        watch.setImage8(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                    }
                }
            }
            if(videofile != null){
                String fileName = Methods.createName(videofile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videofile.isEmpty()){
                    videofile.transferTo(new File(path));
                    watch.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }
            if(fileImg != null){
                String fileName = Methods.createName(fileImg.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!fileImg.isEmpty()){
                    fileImg.transferTo(new File(path));
                    watch.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                }
            }
        }catch (IOException e){

        }
        getComboxId(watch);
        watchService.add(watch);
        return ControllerResult.getSuccessResult("添加成功");
    }

    @ResponseBody
    @RequestMapping(value="update_watch",method = RequestMethod.POST)
    public ControllerResult updateWatch(Watch watch,MultipartFile videofile,String video){
        logger.info("更新手表基本信息");
        try {
            if(videofile != null){
                String fileName = Methods.createName(videofile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videofile.isEmpty()){
                    videofile.transferTo(new File(path));
                    watch.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }else{
                watch.setVideo(video);
            }

        }catch (IOException e){

        }
        getComboxId(watch);
        watchService.update(watch);
        return ControllerResult.getSuccessResult("更新成功");
    }

    @ResponseBody
    @RequestMapping(value="update_watchImg",method = RequestMethod.POST)
    public ControllerResult updateWatchImg(Watch watch,MultipartFile file1,MultipartFile file2,MultipartFile file3,
                                           MultipartFile file4,MultipartFile file5,MultipartFile file6,MultipartFile file7,
                                           MultipartFile file8,MultipartFile file9){
        logger.info("更新手表图片");
        try {
            Watch watch1 = watchService.queryById(watch.getId());
            if(file1 != null){
                String fileName = Methods.createName(file1.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file1.transferTo(new File(path));
                watch.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage(watch1.getImage());
            }
            if(file2 != null){
                String fileName = Methods.createName(file2.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file2.transferTo(new File(path));
                watch.setImage1(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage1(watch1.getImage1());
            }
            if(file3 != null){
                String fileName = Methods.createName(file3.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file3.transferTo(new File(path));
                watch.setImage2(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage2(watch1.getImage2());
            }

            if(file4 != null){
                String fileName = Methods.createName(file4.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file4.transferTo(new File(path));
                watch.setImage3(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage3(watch1.getImage3());
            }

            if(file5 != null){
                String fileName = Methods.createName(file5.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file5.transferTo(new File(path));
                watch.setImage4(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage4(watch1.getImage4());
            }

            if(file6 != null){
                String fileName = Methods.createName(file6.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file6.transferTo(new File(path));
                watch.setImage5(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage5(watch1.getImage5());
            }

            if(file7 != null){
                String fileName = Methods.createName(file7.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file7.transferTo(new File(path));
                watch.setImage6(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage6(watch1.getImage6());
            }
            if(file8 != null){
                String fileName = Methods.createName(file8.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file8.transferTo(new File(path));
                watch.setImage7(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage7(watch1.getImage7());
            }
            if(file9 != null){
                String fileName = Methods.createName(file9.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                file9.transferTo(new File(path));
                watch.setImage8(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
            }else{
                watch.setImage8(watch1.getImage8());
            }

        }catch (IOException e){

        }
        watchService.updateImg(watch);
        return ControllerResult.getSuccessResult("更新成功");
    }



    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        logger.info("删除手表");
        watchService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }


    /*
    * 根据页面的comboxID设置到手表类
    * */
    public void getComboxId(Watch watch){
        Core core = new Core();
        core.setId(watch.getCore().getId());
        Material material = new Material();
        material.setId(watch.getMaterial().getId());
        Origin origin = new Origin();
        origin.setId(watch.getOrigin().getId());
        Brand brand = new Brand();
        brand.setId(watch.getBrand().getId());
        Style style = new Style();
        style.setId(watch.getStyle().getId());
        watch.setStyle(style);
        watch.setBrand(brand);
        watch.setOrigin(origin);
        watch.setMaterial(material);
        watch.setCore(core);
    }

}
























