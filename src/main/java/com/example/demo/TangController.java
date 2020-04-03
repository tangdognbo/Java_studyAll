package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;

@RestController
public class TangController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/delete")
    Object home111() {
        jdbcTemplate.update("delete from user where id=?", new Object[]{10});
        return "Hello World!1";
    }


    @RequestMapping("/")
    Object home11111111111111() {

        String test1="tang";
        test1.equals("111");
        //HashMap
        return "Hello World!";
    }
}
