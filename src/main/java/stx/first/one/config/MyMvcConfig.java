package stx.first.one.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import stx.first.one.component.LoginHandlerInterceptor;
import stx.first.one.component.MylocaleResolver;

@Configuration
public class MyMvcConfig {

    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/").setViewName("login");
    }


    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**").excludePathPatterns("/index.html","/","/static/**","/webjars/**","/user/login");
            }
            //静态文件

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//静态文件
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//webjar文件
                registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
            }
        };

        return adapter;

    //静态文件


}
    @Bean
    public LocaleResolver localeResolver(){

        return new MylocaleResolver();
    }
}
