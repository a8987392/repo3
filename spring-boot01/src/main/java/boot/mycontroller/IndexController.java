package boot.mycontroller;

import boot.myclasses.User;
import boot.service.Mapper001ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class IndexController {




    @Autowired
    Mapper001ServiceImpl service;



    @GetMapping("/login")
    public  String login(){

        return "login";

    }

    @PostMapping("/login")
    public String tomain(User user, HttpSession session){
        if(user.getUsername().equals("")||user.getPassword().equals("")){
            return null;

        }else{

            session.setAttribute("user",user);

            return "redirect:/main";
        }



    }

    @GetMapping("/main")
    public  String mainPage(HttpSession session, Model model){



            return "main";
    }

    @GetMapping("/upload")
    public String toupload(){

        return "upload";

    }

    @PostMapping("/multiupload")

    public String upload(HttpServletRequest request,HttpServletResponse response){

        System.out.println("进入了");
        List<MultipartFile> files=((MultipartHttpServletRequest)request).getFiles("file");
        String filePath="F:/upload/";
        for(int i=0;i<files.size();i++){
            MultipartFile file=files.get(i);

            String fileName=file.getOriginalFilename();


            File dest =new File(filePath+fileName);
            try{
                file.transferTo(dest);
                System.out.println("上传成功！");
            }catch (IOException ioe){
                ioe.printStackTrace();
                System.out.println("上传失败！");
            }
        }
        return "login";
    }



    @GetMapping("/sql")
    @ResponseBody
    public void toshow(){


       service.counttest();


    }



}
