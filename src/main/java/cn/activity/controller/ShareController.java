package cn.activity.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ShareController {

    @RequestMapping("shareeditor")
    public String shareEditor(){
        return "shareeditor";
    }

    @RequestMapping(value = "ueditor.html", method = RequestMethod.GET)
    public @ResponseBody String ueUpload(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        //这里就是把controller.jsp代码copy下来
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String roolPath = request.getSession().getServletContext().getRealPath("/");
        String configStr = new ActionEnter(request, roolPath).exec();
        return configStr;
    }

    /*@RequestMapping("js/dialogs/image/image.html")
    public String share(){
        return "js/dialogs/image/image";
    }*/
    @RequestMapping("controller")
    public ModelAndView shareController(@RequestParam("action") String action){
       ModelAndView mav = new ModelAndView();
       mav.setViewName("/controller.jsp");
       mav.addObject("action",action);
       return  mav;
    }


}
