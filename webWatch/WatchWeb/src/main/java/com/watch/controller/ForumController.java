package com.watch.controller;

import ch.qos.logback.classic.Logger;
import com.watch.bean.*;
import com.watch.common.Constants;
import com.watch.common.Methods;
import com.watch.common.bean.ControllerResult;
import com.watch.common.bean.Pager;
import com.watch.common.bean.Pager4EasyUI;
import com.watch.service.AdminService;
import com.watch.service.ForumService;
import jdk.management.resource.ResourceMeter;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Controller
@RequestMapping("/forum")
public class ForumController {

    private Logger logger = (Logger) LoggerFactory.getLogger(ForumController.class);

    @Resource
    private ForumService forumService;

    @Resource
    private AdminService adminService;

    /**
     * 后台论坛管理*/
    @RequestMapping(value = "forum_page",method = RequestMethod.GET)
    public String redirectForum(Model model) {
        return "/admin-page/forum-page";
    }


    /**
     * 根据Id跳转帖子详情*/
    @RequestMapping(value = "details/{id}",method = RequestMethod.GET)
    public ModelAndView redirectDetails(@PathVariable("id")int id) {
        logger.info("根据手表ID查询手表");
        Forum forum = forumService.queryById(id);
        ModelAndView mav = new ModelAndView("watch/forum-font");
        mav.addObject("forum",forum);
        return mav;
    }

    /**
     * 查看论坛并且分页*/
    @RequestMapping(value = "forum/{pager}",method = RequestMethod.GET)
    public ModelAndView redirectForum(HttpServletRequest req,@PathVariable("pager")String pageNoStr) {
        logger.info("专业技术贴复刻循环输出");
        int pageNo = 1;
        int pageSize = 4;
        Forum forum = new Forum();
        int total = forumService.queryByCount();
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
        List<Forum> forums = forumService.queryByAll(pager);
        List<Forum> forumMB = forumService.queryByMB();
        List<Forum> fourmPP = forumService.queryByPP();
        ModelAndView mav = new ModelAndView("watch/forum");
        mav.addObject("forum", forums);
        mav.addObject("forumPP", fourmPP);
        mav.addObject("forumMB", forumMB);
        mav.addObject("totalPages", totalPage);
        mav.addObject("currentPage", pageNo);
        return mav;
    }


    @ResponseBody
    @RequestMapping(value="query_pager",method=RequestMethod.GET)
    public Pager4EasyUI<Forum> queryPager(@Param("page")String page, @Param("rows")String rows){
        logger.info("分页查询所有帖子");
        Pager4EasyUI<Forum> pager = new Pager4EasyUI<Forum>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Forum forum = new Forum();
        pager = forumService.queryByPagerAndCriteria(pager,forum);
        return pager;
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method= RequestMethod.GET)
    public Pager4EasyUI<Forum> queryAll(@Param("page") String page, @Param("rows")String rows){
        Pager4EasyUI<Forum> pager = new Pager4EasyUI<Forum>();
        pager.setPageNo(Integer.valueOf(page));
        pager.setPageSize(Integer.valueOf(rows));
        Forum forum = new Forum();
        pager = forumService.queryByPagerAndCriteria(pager,forum);
        return pager;
    }

    /*更新帖子*/
    @ResponseBody
    @RequestMapping(value="update_forum", method = RequestMethod.POST)
    public ControllerResult updateForum(Forum forum, MultipartFile imageFile, MultipartFile videoFile, String video, String image,String des){
        logger.info("更新论坛基本信息");
        try {
            if(videoFile != null){
                String fileName = Methods.createName(videoFile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videoFile.isEmpty()){
                    videoFile.transferTo(new File(path));
                    forum.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }else{
                forum.setVideo(video);
            }
            if(imageFile != null){
                String fileName = Methods.createName(imageFile.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!imageFile.isEmpty()){
                    imageFile.transferTo(new File(path));
                    forum.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                }
            }else{
                forum.setImage(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(des==null && des.equals("")){
            forum.setDes(des);
        }
        getComboxId(forum);
        forumService.update(forum);
        return ControllerResult.getSuccessResult("更新成功");
    }




    /*添加帖子*/
    @ResponseBody
    @RequestMapping(value="add_forum",method = RequestMethod.POST)
    public ControllerResult addForum(Forum forum, MultipartFile imageFile, MultipartFile videoFile){
        logger.info("添加论坛基本信息");
        try {
            if(videoFile != null){
                String fileName = Methods.createName(videoFile.getOriginalFilename());
                String path = Methods.uploadPath("video") + fileName;
                if(!videoFile.isEmpty()){
                    videoFile.transferTo(new File(path));
                    forum.setVideo(Constants.UPLOAD_VIDEO + Methods.createNewFolder() + "/" + fileName);
                }
            }else{

            }
            if(imageFile != null){
                String fileName = Methods.createName(imageFile.getOriginalFilename());
                String path = Methods.uploadPath("img") + fileName;
                if(!imageFile.isEmpty()){
                    imageFile.transferTo(new File(path));
                    forum.setImage(Constants.UPLOAD_IMAGES + Methods.createNewFolder() + "/" + fileName);
                }
            }else{

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        getComboxId(forum);
        forumService.add(forum);
        return ControllerResult.getSuccessResult("添加成功");
    }


    /*
    * 根据页面的comboxID设置到手表类
    * */

    public void getComboxId(Forum forum){
        Type type = new Type();
        type.setId(forum.getType().getId());
        forum.setType(type);

        Admin admin = new Admin();
        admin.setId(forum.getAdmin().getId());
        forum.setAdmin(admin);
    }

    /*格式化时间*/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /*删除帖子*/
    @ResponseBody
    @RequestMapping(value="deleteById",method = RequestMethod.GET)
    public ControllerResult deleteById(@Param("ids") String ids){
        logger.info("删除帖子");
        forumService.deleteByIds(ids);
        return ControllerResult.getSuccessResult("删除成功");
    }

}
























