package boot.myclasses;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@ConfigurationProperties("person")
@Component
@Data
public class Worker implements Person {

    private String name;
    private  int age;



}
