package xyz.yhsj.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yhsj.hello.bean.TodoBean;
import xyz.yhsj.hello.dao.TodoDao;


import java.util.List;

/**
 * 数据库操作服务
 * Created by LOVE on 2016/12/28 028.
 */
@Service
public class TodoService {
    @Autowired
    private TodoDao todoDao;

    public void add(TodoBean todoBean) {
        this.todoDao.add(todoBean);
    }

    public void update(TodoBean todoBean) {
        this.todoDao.update(todoBean);
    }

    public void delete(String id) {
        this.todoDao.delete(id);
    }

    public TodoBean findTodo(String id) {
        return this.todoDao.findTodo(id);
    }

    public List<TodoBean> findTodoList() {
        return this.todoDao.findTodoList();
    }
}
