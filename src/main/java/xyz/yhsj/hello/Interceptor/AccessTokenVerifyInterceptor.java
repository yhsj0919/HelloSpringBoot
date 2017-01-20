package xyz.yhsj.hello.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Access Token拦截器
 * Created by LOVE on 2017/1/20 020.
 */
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

    private
    final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOG.warn("AccessToken executing ...");
        boolean flag = true;

        // token

        String accessToken = request.getParameter("token");


        LOG.warn("accessToken ..." + accessToken);

//        if (StringUtils.isNotBlank(accessToken)) {
//            // 验证
//            ValidationModel v = validationService.verifyAccessToken(accessToken);
//            // 时间过期
//            // 用户验证
//
//            if (v != null) {
//                User user = userService.findById(v.getUid());
//                if (user != null) {
//                    request.setAttribute(CommonConst.PARAM_USER, user);
//                    LOG.info("AccessToken SUCCESS ...  user:" + user.getUserName() + " - " + accessToken);
//                    flag = true;
//                }
//            }
//        }

        if (!flag) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("Token验证失败");
        }
        return flag;
    }

}