package cn.activity.controller;

import cn.activity.Utils.RandomUtils;
import cn.activity.Utils.StringUtils;
import cn.activity.domain.Page;
import cn.activity.domain.Share;
import cn.activity.domain.ShareComment;
import cn.activity.service.ShareService;
import cn.activity.service.UserService;
import com.baidu.ueditor.ActionEnter;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShareController {

    @Autowired
    public ShareService shareService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public UserService userService;

    @Autowired
    public void setShareService(ShareService shareService) {
        this.shareService = shareService;
    }

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
        Map<String, Object> params = new HashMap<String, Object>();
        response.setHeader("Content-Type" , "application/json");
        try{
            /*String basePath = LoadPropertiesDataUtils.getValue("lyz.uploading.url");
            String visitUrl = LoadPropertiesDataUtils.getValue("lyz.visit.url");*/
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


    @RequestMapping(value = "insertshare.html" ,method = RequestMethod.POST)
    public @ResponseBody String insertShare(@Param("title")String title,@Param("content")String content){
        System.out.println("1");
        Share share = new Share();
        share.setContent(content.getBytes());
        share.setTitle(title);
        int id = shareService.insertShareContentReturnId(share);
        Share share1 = shareService.getShareById(id);
        byte[] s = share1.getContent();
        String ss = new String(s);
        System.out.println(ss);
        return id+"";
    }

    @RequestMapping(value = "addimage.html",method = RequestMethod.POST)
    public @ResponseBody String addImageById(@RequestParam("head")MultipartFile head,@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("id:"+id);
        String basePath = request.getSession().getServletContext().getRealPath("/share");
        System.out.println(basePath);
        String ext = StringUtils.getExt(head.getOriginalFilename());
        System.out.println(ext);
        String fileName = id + "."+ ext;
        System.out.println(fileName);
        basePath = basePath + "/" + fileName;
        File f = new File(basePath);
        if(!f.exists()){
            f.getParentFile().mkdirs();
        }
        OutputStream out = new FileOutputStream(f);
        FileCopyUtils.copy(head.getInputStream(), out);
        return "1";
    }

    @RequestMapping(value="share.html")
    public ModelAndView Share(@RequestParam(value = "page",defaultValue = "1") String page){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("share");
        Page<Share> dataByPage = shareService.getDataByPage(Integer.parseInt(page));
        modelAndView.addObject("data",dataByPage);
        return modelAndView;
    }

    @RequestMapping(value = "shareitem")
    public ModelAndView ShareItem(@RequestParam(value = "id")int shareid,@RequestParam(value = "page",defaultValue = "1") int page, HttpSession session){
        int userid = (int) session.getAttribute("id");
        Share share = shareService.getShareById(shareid);
        Page<ShareComment> shareComment = shareService.getDataBypageShareId(page,shareid);
        List<String> commentUserName = userService.getUserNameFromCommentList(shareComment.getData());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("shareitem");
        modelAndView.addObject("share",share);
        modelAndView.addObject("page",page);
        modelAndView.addObject("comment",shareComment);
        modelAndView.addObject("commentusername",commentUserName);
        return modelAndView;
    }

    @RequestMapping("addlike")
    public @ResponseBody int addLike(@RequestParam(value = "id") int id){
        ShareComment shareComment = shareService.getShareCommentById(id);
        Integer likes = shareComment.getLikes();
        shareComment.setLikes(likes + 1);
        return shareService.updateCommentById(shareComment);
    }

    @RequestMapping("addComment")
    public ModelAndView addCommentById(@RequestParam("id") int shareId ,@RequestParam("content")String content,HttpSession session){
        int userId = (int) session.getAttribute("id");
        ShareComment shareComment = new ShareComment();
        shareComment.setContent(content);
        shareComment.setLikes(0);
        shareComment.setShareId(shareId);
        shareComment.setUserId(userId);
        shareComment.setCreateTime(new Date());
        shareService.addShareComment(shareComment);
        return ShareItem(shareId,1,session);
    }
}
