package configs;


import configs.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
//@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private LoginInterceptor loginInterceptor;




    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**").addResourceLocations("classpath:/static/");
    }

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/**").excludePathPatterns("/login","/CSS/**","/image/**");



    }







}



