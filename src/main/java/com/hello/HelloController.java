package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

//    @Autowired
//    HelloService helloService;

//    @Autowired
//    DataSource dataSource;
//    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public HelloController() {
    }

    //    @RequestMapping("/")
    @GetMapping(value = "/", produces = "application/json")
//    public String hello() {
//        String data = new HelloService().argGis();
//        return data;
//    }

    @RequestMapping("/another")
    public String anotherPath() {
        return "just another path";
    }

//    @Transactional
    @RequestMapping(value = "/db")
    public int getFromDb() {
        String sql1 = "create table anotherTable(id int)";
        String sql2 = "create table tableFromCode(id int)";
        String sql3 = "insert into stable values (1,'testingg')";
        jdbcTemplate.update(sql1);
        jdbcTemplate.update(sql2);
        jdbcTemplate.update(sql3);
        return 1;
    }
}