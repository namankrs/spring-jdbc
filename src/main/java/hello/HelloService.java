package hello;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.*;


@Service
public class HelloService {

    private final RestTemplate restTemplate;


    public HelloService() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
//        restTemplate = restTemplateBuilder.build();
        this.restTemplate = new RestTemplate();
    }

    public String argGis() {
        return this.restTemplate.getForObject("https://services3.arcgis.com/GVgbJbqm8hXASVYi/arcgis/rest/services/Trailheads/FeatureServer/0?f=json", String.class);
    }

    public String QueryDatabase() throws ClassNotFoundException {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=first;user=SA;password=C0mplexPwd";
        StringBuilder result = new StringBuilder();


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            Statement stmt = con.createStatement();
            String SQL = "USE first;SELECT * from ftable";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                result.append(rs.getString("name"));
                result.append(rs.getInt("id"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
