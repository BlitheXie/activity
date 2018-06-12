package cn.activity.controller;

import cn.activity.Utils.SessionUtil;
import cn.activity.domain.User;
import cn.activity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "admin")
    public String showAdmin(HttpSession session){
        if(session.getAttribute("id") == null)
            return "main";
        else
            return "admin";
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
