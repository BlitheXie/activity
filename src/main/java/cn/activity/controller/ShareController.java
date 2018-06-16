package cn.activity.controller;

import cn.activity.Utils.LoadPropertiesDataUtils;
import cn.activity.Utils.RandomUtils;
import cn.activity.Utils.StringUtils;
import com.baidu.ueditor.ActionEnter;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

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

/*    @RequestMapping(value = "ueditor.html")
    public void shareUpload(@RequestParam(value = "action",required = true) String action){
        System.out.println("jijijiji");
    }*/
    /*@RequestMapping(value = "ueditor.html", method = RequestMethod.POST)*/

    @RequestMapping(value = "ueditor.html",method = RequestMethod.POST)
    @ResponseBody
    public String images (@RequestParam("upfile")MultipartFile upfile, HttpServletRequest request, HttpServletResponse response){
        Gson gson=new Gson();
        System.out.println("upfile");
        Map<String, Object> params = new HashMap<String, Object>();
        response.setHeader("Content-Type" , "application/json");
        try{
            /*String basePath = LoadPropertiesDataUtils.getValue("lyz.uploading.url");
            String visitUrl = LoadPropertiesDataUtils.getValue("lyz.visit.url");*/
            System.out.println(request.getSession().getServletContext().getContextPath());
            System.out.println(request.getSession().getServletContext().getRealPath("/"));
            System.out.println(request.getSession().getServletContext().getRealPath("/user"));

            String basePath = request.getSession().getServletContext().getRealPath("/user");
            /*if(basePath == null || "".equals(basePath)){
                basePath = "d:/lyz/static";  //与properties文件中lyz.uploading.url相同，未读取到文件数据时为basePath赋默认值
            }*/
            /*if(visitUrl == null || "".equals(visitUrl)){
                visitUrl = "/upload/"; //与properties文件中lyz.visit.url相同，未读取到文件数据时为visitUrl赋默认值
            }*/
            String ext = StringUtils.getExt(upfile.getOriginalFilename());
            String fileName = String.valueOf(System.currentTimeMillis()).concat("_").concat(RandomUtils.getRandom(6)).concat(".").concat(ext);
            StringBuilder sb = new StringBuilder();
            //拼接保存路径
            sb.append(basePath).append("/").append(fileName);
            String returnUrl = "http://localhost:8080/user/"+fileName;
            System.out.println(returnUrl);
            File f = new File(sb.toString());
            if(!f.exists()){
                f.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(f);
            FileCopyUtils.copy(upfile.getInputStream(), out);
            params.put("state", "SUCCESS");
            params.put("url", returnUrl);
            params.put("size", upfile.getSize());
            params.put("original", fileName);
            params.put("type", upfile.getContentType());
            System.out.println(params.toString());
        } catch (Exception e){
            e.printStackTrace();
            params.put("state", "ERROR");
        }
        return gson.toJson(params);
    }


    @RequestMapping("")
    public @RequestBody String insertShare(){

    }
}
