package com.watch.controller;

import com.watch.bean.Watch;
import com.watch.service.WatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private WatchService watchService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String redirectHome(Model model) {
        List<Watch> watchs1 = watchService.queryBy12(0,4);
        List<Watch> watchs2 = watchService.queryBy12(4,4);
        List<Watch> watchs3 = watchService.queryBy12(8,4);
        model.addAttribute("watchs1",watchs1);
        model.addAttribute("watchs2",watchs2);
        model.addAttribute("watchs3",watchs3);
        return "watch/home";
    }

}
