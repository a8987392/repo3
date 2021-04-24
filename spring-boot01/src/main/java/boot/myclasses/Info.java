package boot.myclasses;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "info")
@Data
@ToString

public class Info {
    private String brand;
    private int price;
    private Pet pet;
    private String []balls;
    private List games;
    private Map<String,String> heros;
    private Map<String,List<String>> herostype;




}
