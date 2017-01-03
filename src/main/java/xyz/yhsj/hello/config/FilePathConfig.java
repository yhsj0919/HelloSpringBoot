package xyz.yhsj.hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 静态资源配置
 * Created by LOVE on 2017/1/3 003.
 */
@Configuration
public class FilePathConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义目录
        //这样使用代码的方式自定义目录映射，并不影响Spring Boot的默认映射，可以同时使用。
        //如果我们将/imgs/* 修改为 /* 与默认的相同时，则会覆盖系统的配置，可以多次使用 addResourceLocations 添加目录，优先级先添加的高于后添加的
        //其中addResourceLocations 的参数是动参，可以这样写addResourceLocations(“classpath:/img1/”, “classpath:/img2/”,“classpath:/img3/”);
        registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/imgs/");
        super.addResourceHandlers(registry);

        //使用外部目录
        //如果我们要指定一个绝对路径的文件夹（如 D:/data/api_files ），则只需要使用 addResourceLocations 指定即可。
        //可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上file:
//        registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/data/api_files");
    }
}
