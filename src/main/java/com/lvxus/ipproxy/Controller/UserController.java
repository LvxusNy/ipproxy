package com.lvxus.ipproxy.Controller;

import com.lvxus.ipproxy.Entity.User;
import com.lvxus.ipproxy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    @ResponseBody
    public String saveUser(@RequestBody User user){
        if (userRepository.selectUserByLoginName(user.getLoginName()) >= 1){
            return "用户名已存在！";
        }
        int result = userRepository.addUser(user);
        String str = "";
        if (result < 1) str = "增加用户失败!";
        str = "增加用户成功!";
        return str;
    }
}
