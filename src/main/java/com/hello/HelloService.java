package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HelloService {

    private final RestTemplate restTemplate = new RestTemplate();


//    @Autowired
//    DataSource dataSource;
//    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Autowired
    JdbcTemplate jdbcTemplate;


public HelloService(JdbcTemplate jdbcTemplate) {
////        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
////        restTemplate = restTemplateBuilder.build();
////        this.restTemplate = new RestTemplate();
//        this.jdbcTemplate = jdbcTemplate;
    }

    public String argGis() {
        return this.restTemplate.getForObject("https://services3.arcgis.com/GVgbJbqm8hXASVYi/arcgis/rest/services/Trailheads/FeatureServer/0?f=json", String.class);
    }

    public int QueryDatabase() {
                String sql = "insert into ftable values (1,'testin')";

        jdbcTemplate.execute(sql);
        return 1;

    }















//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


        //        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=first;user=SA;password=C0mplexPwd";
//        StringBuilder result = new StringBuilder();
//
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection con = DriverManager.getConnection(connectionUrl);
//            Statement stmt = con.createStatement();
//            String SQL = "USE first;SELECT * from ftable";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                result.append(rs.getString("name"));
//                result.append(rs.getInt("id"));
//            }
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result.toString();
//    }
    }
