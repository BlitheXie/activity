package dao;

import cn.activity.dao.UserMapper;
import cn.activity.domain.User;
import cn.activity.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.soap.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest{


    @Test
    public void insert(){
        User user = new User();
        user.setName("asdfb");
        user.setPassword("123456");
        user.setStuNumber("201521314");
        user.setGender("男");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        SqlSessionTemplate sqlSessionTemplate = ctx.getBean(SqlSessionTemplate.class);
        UserMapper userMapper = sqlSessionTemplate.getMapper(UserMapper.class);
        userMapper.insert(user);
    }
    @Test
    public void insert2(){
        UserService userService = new UserService();

    }

    @Test
    public void getByStuNumber(){
        UserService userService = new UserService();
        boolean b = userService.cheackPassword("20152131", "123456");
        System.out.println(b);
    }

    @Test
    public void saveHead(){
        UserService userService = new UserService();
        Logger log = LoggerFactory.getLogger(UserMapperTest.class);
        log.debug("log4测试" );
    }

    @Test
    public void jsoupTest(){
        try {
            Document doc = Jsoup.connect("https://music.douban.com/subject/27999304/").get();
            Elements select = doc.select("#wrapper h1 span");
            Elements big = doc.select("#info");
            Elements big_pl = doc.select("#info .pl");
            String artist ="";
            List<TextNode> textNodes1 = null;
            Element element = big.get(0);
            textNodes1 = element.textNodes();
            System.out.println(textNodes1);
            List<String> result = new ArrayList<>();
            for (int i = 0;i<textNodes1.size();i++){
                TextNode tn = textNodes1.get(i);
                System.out.println(tn.text());
                if (!tn.text().trim().equals("")){
                    result.add(tn.text());
                }
            }
            for (int i = 0 ;i<result.size();i++){
                System.out.println(result.get(i));
            }
            for (Element e :
                    big_pl) {
                if(e.text().startsWith("表演者")){
                    artist = e.select("a").text();
                }
            }

            System.out.println(select.html());//TITLE
            String title = doc.title();
            System.out.println(artist);
            if (result.size()>5)
                result.remove(0);
            System.out.println("time:"+result.get(3));
            System.out.println("public"+result.get(4));

            Elements scoreBan = doc.select("#interest_sectl .rating_self strong");
            String score = scoreBan.text();
            System.out.println(score);
            Elements countBan =doc.select("#interest_sectl .rating_sum a span");
            String count = countBan.text();
            System.out.println(count);
            Elements headBan =doc.select("#mainpic img");
            System.out.println(headBan.attr("src"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
