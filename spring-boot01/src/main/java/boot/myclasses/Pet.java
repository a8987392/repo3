package boot.myclasses;


import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
public class Pet {
    private float weight;
    private String name;



}
