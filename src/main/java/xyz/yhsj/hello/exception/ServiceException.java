package xyz.yhsj.hello.exception;

/**
 * 自定义异常类
 * Created by LOVE on 2017/1/3 003.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}