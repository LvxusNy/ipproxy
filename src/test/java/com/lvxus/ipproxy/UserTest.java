package com.lvxus.ipproxy;

import com.lvxus.ipproxy.Entity.User;
import com.lvxus.ipproxy.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void add_user_test(){
        User user = new User();
        user.setLoginName("test");
        user.setPassword("test");
        user.setUsername("test");
        int result = userRepository.addUser(user);
        Assert.assertEquals(1,result);
    }
}
