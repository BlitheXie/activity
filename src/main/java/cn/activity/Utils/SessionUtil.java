package cn.activity.Utils;

import cn.activity.domain.User;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static void changeSession(HttpSession session, User user){
        session.setAttribute("studentNumber",user.getStuNumber());
        session.setAttribute("id",user.getId());
        session.setAttribute("userName",user.getName());
        session.setAttribute("userGender",user.getGender());
        session.setAttribute("createTime",user.getCreateTime());
    }
}
