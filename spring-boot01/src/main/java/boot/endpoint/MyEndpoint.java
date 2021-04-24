package boot.endpoint;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="myendpoint")
public class MyEndpoint {

    @ReadOperation
    public Map read(){

        Map <String,String> map=new HashMap<String,String>();
        map.put("status","service stated");
        return  map;
    }

    @WriteOperation
    public void write(){

        System.out.println("test");

    }




}
