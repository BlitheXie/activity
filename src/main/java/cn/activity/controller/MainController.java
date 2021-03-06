package cn.activity.controller;

import cn.activity.service.ActivityService;
import cn.activity.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    public ShareService shareService;

    public ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Autowired
    public void setShareService(ShareService shareService) {
        this.shareService = shareService;
    }



    @RequestMapping("main.html")
    public ModelAndView showMainPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("shareList",shareService.getAllShare());
        mav.addObject("activityList",activityService.selectAllOrderByTime());
        mav.setViewName("main");
        return mav;
    }
}
