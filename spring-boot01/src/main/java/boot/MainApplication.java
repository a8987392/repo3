package boot;

import configs.BeanConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@ServletComponentScan("configs")


@ComponentScan(value= "configs")
@ComponentScan(value= "boot")
//EnableConfigurationProperties(MyCar.class)
public class MainApplication {
    public static  void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);
        ConfigurableEnvironment en= run.getEnvironment();
       Map<String,Object> map1=en.getSystemEnvironment();
       System.out.println(map1);
       Map<String,Object> map2= en.getSystemProperties();
        System.out.println(map2);



    }


}
