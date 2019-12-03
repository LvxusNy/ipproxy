package com.lvxus.ipproxy.Repository;

import com.lvxus.ipproxy.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.util.Map;

@Repository("userRepository")
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addUser(User user){
        String md5_password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        return jdbcTemplate.update("INSERT INTO sys_user(LOGIN_NAME,PASSWORD,USER_NAME) VALUES(?,?,?)",
                new Object[]{user.getLoginName(),md5_password,user.getUsername()});
    }
    public int selectUserByLoginName(String loginName){
        return jdbcTemplate.queryForObject("select count(1) from sys_user where login_name = ?",new Object[]{loginName},Integer.TYPE);
    }

}
