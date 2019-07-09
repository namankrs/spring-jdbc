package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    //    @RequestMapping("/")
    @GetMapping(value = "/", produces = "application/json")
    public String hello() {
        String data = new HelloService().argGis();
        return data;
    }

    @RequestMapping("/another")
    public String anotherPath() {
        return "just another path";
    }

    @RequestMapping(value = "/db")
    public String getFromDb() throws ClassNotFoundException {
        return new HelloService().QueryDatabase();
    }
}