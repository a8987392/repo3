package boot.mycontroller;


import boot.myclasses.Info;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MyController {

    @Autowired
    private Info info;



    @RequestMapping("/hello")
    public String returnString(){
        return "hello world";


    }



    @RequestMapping("/car")
    public Info returnCar(){
        System.out.println(info);
        log.info("日志测试");

        return info;


    }

    @RequestMapping (value = "/user" ,method = RequestMethod.POST)
    public String postUser(){

    return "处理Post请求";

    }


    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String getUser(){

        return "处理Get请求";

    }


    @PutMapping(value = "/user" )
    public String PutUser(){

        return "处理Put请求";

    }

    @RequestMapping(value = "/user" ,method = RequestMethod.DELETE)
    public String deleteUser(){

        return "处理Delete请求";

    }







}
