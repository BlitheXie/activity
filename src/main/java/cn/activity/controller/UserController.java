package cn.activity.controller;

import cn.activity.domain.User;
import cn.activity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext servletContext;
    @RequestMapping(value = "login.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "test.html")
    public String test(){
        boolean b = userService.cheackPassword("20152131", "12ww3456");
        System.out.println(b);
        return "login";
    }

    @RequestMapping(value = "checkPassword",method = RequestMethod.POST,params = {"studentNumber","password"})
    public String checkPassword(@RequestParam("studentNumber") String studentNumber, @RequestParam("password") String password,HttpSession session ){
        if (userService.cheackPassword(studentNumber,password)){
            User user = userService.getUserByStuNum(studentNumber);
            session.setAttribute("studentNumber",user.getStuNumber());
            session.setAttribute("id",user.getId());
            session.setAttribute("userName",user.getName());
            System.out.println(user.getName());
            session.setAttribute("userGender",user.getGender());
            session.setAttribute("createTime",user.getCreateTime());
            return "success";
        }
        return "fail";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "register.html",method = RequestMethod.POST)
    public String insertUser(@RequestParam("number")String stuNumber,@RequestParam("name") String name,@RequestParam("password")String password,HttpSession session ){
        User user = new User();
        user.setName(name);
        user.setGender("");
        user.setStuNumber(stuNumber);
        user.setPassword(password);
        userService.insertUser(user);
        session.setAttribute("studentNumber",user.getStuNumber());
        session.setAttribute("id",user.getId());
        session.setAttribute("userName",user.getName());
        session.setAttribute("userGender",user.getGender());
        session.setAttribute("createTime",user.getCreateTime());
        return "forward:/main.html";
    }

    @RequestMapping("checknumber")
    public String checkStudentNumber(@RequestParam("number") String number){
        List<User> users = userService.getAllUserByNumber(number);
        if(users.size() == 0){
            return "fail";
        }
        return "success";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
