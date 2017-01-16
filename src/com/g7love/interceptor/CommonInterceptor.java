package com.g7love.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class CommonInterceptor extends HandlerInterceptorAdapter{

	private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

    public  static  final  String  LAST_PAGE = "lastPage";
    public static String userid;
    /** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     *     
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
    /*@Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {            
        if ("GET".equalsIgnoreCase(request.getMethod())) {
                //RequestUtil.saveRequest();
        }
        log.info("==============执行顺序: 1、preHandle================");  
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        if ("/permissions/login".equals(url)) {    
            log.info("login");
            return true;
        }else {               
            String username =  (String)request.getSession().getAttribute("username");
            
            if(username != null){
                log.info("Interceptor：跳转到login页面！");
                //request.getRequestDispatcher("/page/index.jsp").forward(request, response);
                return false;
            }else
                return true;
       }
        
    }*/
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                               Object handler) throws Exception { 
          // 获得请求路径的uri
          String uri = request.getRequestURI();

          // 判断路径是登出还是登录验证，是这两者之一的话执行Controller中定义的方法
          if(uri.endsWith("/permissions/login") || uri.endsWith("/login/out")) {
              return true;
          }

          // 进入登录页面，判断session中是否有key，有的话重定向到首页，否则进入登录界面
          if(uri.endsWith("/login/") || uri.endsWith("/login")) {
              if(request.getSession() != null && request.getSession().getAttribute("username") != null) {
                  response.sendRedirect(request.getContextPath() + "/index");
              } else {
            	 this.userid = (String)request.getSession().getAttribute("username");
            	 System.out.println(this.userid);
            	 System.out.println("**********");
                 return true;
              }
          }

          // 其他情况判断session中是否有key，有的话继续用户的操作
          if(request.getSession() != null && request.getSession().getAttribute("username") != null) {
        	  this.userid = (String)request.getSession().getAttribute("username");
        	  System.out.println(this.userid);
        	  System.out.println("**********");
              return true;
          }

          // 最后的情况就是进入登录页面
          response.sendRedirect(request.getContextPath() + "/login");
          return false;
    }
    
    
    
    
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作   
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override  
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {   
        log.info("==============执行顺序: 2、postHandle================");  
        if(modelAndView != null){  //加入当前时间  
            modelAndView.addObject("haha", "测试postHandle");  
        }  
    }        
    /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等    
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */  
    @Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
        log.info("==============执行顺序: 3、afterCompletion================");  
    }  
}
