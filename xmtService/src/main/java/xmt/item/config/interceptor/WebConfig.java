package xmt.item.config.interceptor;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截其/继承MVC构造适配器
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //增加拦截器

        registry.addInterceptor(new HandlerInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new HandlerInterceptor()).addPathPatterns("/upload/image");
        System.out.println("handlerInterceptor is already successfully registered !");
}
}
