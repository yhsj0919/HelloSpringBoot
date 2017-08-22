package xyz.yhsj.hello.web;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yhsj.hello.bean.TodoBean;
import xyz.yhsj.hello.service.TodoService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 * Created by LOVE on 2016/12/28 028.
 */
@RestController
@RequestMapping(value = "/api/todo", produces = "application/json;charset=UTF-8")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * 查询TODO列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAuthorList(HttpServletRequest request) {

        List<TodoBean> todoList = this.todoService.findTodoList();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("total", todoList.size());
        param.put("rows", todoList);
        return param;
    }

    /**
     * 查询TODO列表
     */
    @RequestMapping(value = "/{todoId}", method = RequestMethod.GET)
    public TodoBean findTodo(@PathVariable String todoId, HttpServletRequest request) {
        TodoBean todoBean = this.todoService.findTodo(todoId);
        if (todoBean == null) {
            throw new RuntimeException("查询错误");
        }
        return todoBean;
    }

    /**
     * 新增方法
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody TodoBean todoBean) {

//        Map<String, String[]> params = request.getParameterMap();
//        String bodyparams = "";
//        try {
//            BufferedReader br = request.getReader();
//            String str;
//            while ((str = br.readLine()) != null) {
//                bodyparams += str;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        JSONObject jsonObject = JSONObject.parseObject(requestBody);

//        String content = jsonObject.getString("content");
//        int status = jsonObject.getInteger("status");
//        TodoBean todoBean = new TodoBean();

//        todoBean.setContent(content);
        todoBean.setTime(new Date());
//        todoBean.setStatus(status);
        try {
            this.todoService.add(todoBean);
            return "新增完成";
        } catch (Exception e) {
            return "新增错误";

        }
    }

    /**
     * 更新方法
     */
    @RequestMapping(value = "/{todoId}", method = RequestMethod.PUT)
    public String update(@PathVariable String todoId, @RequestBody String requestBody, HttpServletRequest request) {
        TodoBean todoBean = this.todoService.findTodo(todoId);
        if (todoBean != null) {

            JSONObject jsonObject = JSONObject.parseObject(requestBody);

            String content = jsonObject.getString("content");
            int status = jsonObject.getInteger("status");
            todoBean.setContent(content);
            todoBean.setStatus(status);

            try {
                this.todoService.update(todoBean);
                return "更新完成";
            } catch (Exception e) {
                e.printStackTrace();
                return "更新错误";
            }
        } else {
            return "未更新";
        }

    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "/{todoId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String todoId) {
        try {
            this.todoService.delete(todoId);
            return "删除" + todoId;
        } catch (Exception e) {
            return "删除错误";

        }

    }

}
