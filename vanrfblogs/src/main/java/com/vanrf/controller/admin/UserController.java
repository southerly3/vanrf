package com.vanrf.controller.admin;

import com.vanrf.bean.Type;
import com.vanrf.bean.User;
import com.vanrf.mapper.TypeDao;
import com.vanrf.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@CrossOrigin("http://127.0.0.1:8848")
@RequestMapping("/admin")
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    private User us = null;
    private static Map<Long, Long> userDate = new HashMap<>();

    @RequestMapping("/Userlogin")
    public String login(User user) {
        this.us = userDao.login(user);
        if (this.us != null) {
            userDate.put(this.us.getUserId(), new Date().getTime() + 1000000);
            return this.us + "";
        } else {
            System.out.println("账号密码错误");
            return null;
        }
    }

    @RequestMapping("/getName")
    public String getName() {
        try {
            if (userDate.get(this.us.getUserId()) - new Date().getTime() <= 0) {
                userDate.remove(this.us.getUserId());
                return null;
            }
            return this.us.getUsername();
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/getImgs")
    public String getImgs() {
        return  this.us.getImgs();

    }

    @RequestMapping("/getPass")
    public String getPass() {
        return this.us.getPassword();
    }

    @RequestMapping("/userSave")
    public String userSave(Integer id, String password) {
        Integer i = userDao.update(1, password);
        System.out.println(i);
        if (i >=1) {
            System.out.println("修改密码成功");
            return "1";
        }
        System.out.println("修改密码失败");
        return null;
    }
    @RequestMapping("/exit")
    public String exit() {
        Long remove = userDate.remove(this.us.getUserId());
        if(remove!=null){
            return remove+"";
        }
        return "";
    }

    @RequestMapping("/pdUser")
    public String pdUser() {
        if(this.us!=null){

            return 1+"";
        }
        return "";
    }
}
