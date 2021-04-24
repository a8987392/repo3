package configs;


import boot.servlet.myservlet;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.sql.SQLException;
import java.util.Arrays;

@Configuration(proxyBeanMethods = true)

public class BeanConfig {




    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper=new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);

            }
        };
    }


    @Bean
    public ServletRegistrationBean getSerb(){

        myservlet my=new myservlet();

        return  new ServletRegistrationBean(my,"/servlet");

    }


    /*
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DruidDataSource getDruid() throws SQLException {


       DruidDataSource dataSource =new DruidDataSource();
       dataSource.setFilters("stat,wall");

        return dataSource;

    }

    @Bean
    public ServletRegistrationBean createStatServlet(){

        StatViewServlet statViewServlet=new StatViewServlet();

        ServletRegistrationBean <StatViewServlet> srb=new ServletRegistrationBean<StatViewServlet>(statViewServlet,"/druid/*");

        srb.addInitParameter("loginUsername","admin");
        srb.addInitParameter("loginPassword","123456");

        return  srb;

    }

    @Bean
    public  FilterRegistrationBean getWsf(){

        WebStatFilter webStatFilter=new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> registrationBean=new FilterRegistrationBean<WebStatFilter>(webStatFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        registrationBean.addInitParameter("exclusions","*.js,*.css,*.png,/druid/*");
        return  registrationBean;


    }

    */








}












