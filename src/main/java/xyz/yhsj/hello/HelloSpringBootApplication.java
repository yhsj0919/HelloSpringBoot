package xyz.yhsj.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan
@SpringBootApplication//等同于 @Configuration @EnableAutoConfiguration @ComponentScanpublic
public class HelloSpringBootApplication {


    public static void main(String[] args) {
        System.out.println(" springApplication run !");
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }
}
