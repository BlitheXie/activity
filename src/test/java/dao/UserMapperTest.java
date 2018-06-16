package dao;

import cn.activity.dao.UserMapper;
import cn.activity.domain.User;
import cn.activity.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
