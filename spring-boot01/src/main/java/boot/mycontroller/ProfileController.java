package boot.mycontroller;


import boot.myclasses.Person;
import boot.myclasses.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {


    @Value("${person.name}")
    private String name;

   @Autowired
   private Worker worker;

   @Value("${os.name}")
   private String msg;



    @GetMapping("/profile")
    @ResponseBody
    public Worker profileTest(){
        return worker;
    }


    @GetMapping("/enva")
    @ResponseBody
    public String environment_variable(){

        return msg;

    }








}
