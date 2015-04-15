package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootifySampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootifySampleApplication.class, args);
    }
    @RequestMapping("/hello")
    public String demo1(){
    	return "Bootifying, Hello world!!";
    }
   
}
