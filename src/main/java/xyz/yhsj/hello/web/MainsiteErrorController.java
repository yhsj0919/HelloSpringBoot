package xyz.yhsj.hello.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 404处理
 * Created by LOVE on 2016/12/28 028.
 */
@Controller
public class MainsiteErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    /**
     * Supports the HTML Error View
     *
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorHtml(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setStatus(200);
        return "404";
    }

    /**
     * Supports other formats like JSON, XML
     *
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object error(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setStatus(200);
        return "接口不存在";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}