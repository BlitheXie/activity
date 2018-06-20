package cn.activity.controller;

import cn.activity.Utils.SessionUtil;
import cn.activity.domain.User;
import cn.activity.service.ActivityService;
import cn.activity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    ActivityService activityService;

    @Autowired
    UserService userService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "admin")
    public ModelAndView showAdmin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Object userId = session.getAttribute("id");
        if(userId == null){
            modelAndView.setViewName("login");
            return modelAndView;
        }else{
            modelAndView.setViewName("admin");
            modelAndView.addObject("activity",activityService.getUserSignByUserId((int)userId));
            System.out.println(activityService.getUserSignByUserId((int)userId).size());
            System.out.println((int)userId);
            return modelAndView;
        }
    }

    @RequestMapping(value = "updateusermessage" , method = RequestMethod.POST)
    public void updateUserMessage(HttpSession session,@RequestParam("header")String value,@RequestParam("username")String username,@RequestParam("gender")String gender){
        User user = userService.getUserByStuNum(session.getAttribute("studentNumber").toString());
        System.out.println(username + gender);
        user.setName(username);
        user.setGender(gender);
        userService.update(user);
        SessionUtil.changeSession(session,user);
        if(!value.equals("0"))
            userService.saveUserHead(Integer.parseInt(session.getAttribute("id").toString()),servletContext,value);
    }
}
