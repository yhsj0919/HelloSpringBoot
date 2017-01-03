package xyz.yhsj.hello.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import xyz.yhsj.hello.bean.TodoBean;


import java.util.List;

/**
 * 获取数据库内容
 * Created by LOVE on 2016/12/28 028.
 */
@Repository
public class TodoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void add(TodoBean todoBean) {
        this.mongoTemplate.insert(todoBean);
    }

    public void update(TodoBean todoBean) {
        this.mongoTemplate.save(todoBean);
    }

    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        this.mongoTemplate.remove(query, TodoBean.class);
    }

    public TodoBean findTodo(String id) {
        return this.mongoTemplate.findById(id, TodoBean.class);
    }

    public List<TodoBean> findTodoList() {
        Query query = new Query();
        return this.mongoTemplate.find(query, TodoBean.class);
    }
}
