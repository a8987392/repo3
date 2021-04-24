package boot.indicator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class My5555r extends AbstractHealthIndicator {


    @Override

    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String,String> map=new HashMap<String,String>();

        if(2==2){
            builder.status(Status.UP);
            map.put("test1","test1");
            map.put("test2","test2");

        }else{

            builder.status(Status.OUT_OF_SERVICE);

        }


        builder.withDetails(map);


    }
}
