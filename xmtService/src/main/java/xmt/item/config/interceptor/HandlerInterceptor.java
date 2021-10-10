package xmt.item.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一拦截器，这个拦截器要实现HandlerInterceptor接口，这个接口里有四大方法，preHandle是在请求controllor前调用，postHandler在调用Controller方法之后、视图渲染之前调用，afterCompletion是在渲染视图完成之后使用，afterConcurrentHandlingStarted方法用来处理异步请求
 */
@Component
public class HandlerInterceptor extends HandlerInterceptorAdapter {

    //preHandle是在请求controllor前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//        if( !jedis.get(request.getParameter("userId")).equals(request.getParameter("token"))){
//            return false;
//        }
//        System.out.println(request.getParameter("userId")+request.getParameter("nickname")+":"+request.getParameter("token"));
        return true;
    }

    /**
     * postHandler在调用Controller方法之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * afterCompletion是在渲染视图完成之后使用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * afterConcurrentHandlingStarted方法用来处理异步请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param object
     * @throws Exception
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        return;
    }

}
