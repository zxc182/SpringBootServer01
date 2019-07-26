//package com.initspringboot.vueboot.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///**
// * 为应用程序的所有URL注册springSecurityChain过滤器
// */
//public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    @Override
//    protected Class<?>[] getRootConfigClasses() {  //使用Spring MVC 它应该被加入到 getRootConfigClasses()
//        return new Class[] { WebSecurityConfig1.class };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[0];
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[0];
//    }
//
//    // ... other overrides ...
//}
