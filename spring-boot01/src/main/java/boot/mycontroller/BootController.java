package boot.mycontroller;


import boot.myclasses.Book;
import boot.myclasses.MSG;

import boot.service.Mapper001Service;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

@Controller

public class BootController<defaultValue, value> {

    @Autowired
    private JdbcTemplate template;



    @Autowired
    public Mapper001Service service;






    public  BootController(){

    }

    @GetMapping("/userID/{id}/username/{name}/age/{age}/inters/{inters}")
    public String bootParameter(@PathVariable String id,
                                @PathVariable String name,
                                @PathVariable String age,
                                @PathVariable String inters,
                                @PathVariable Map<String,String> map,
                                @RequestHeader ("User-Agent") String header,
                                @RequestHeader Map<String,String> rmap
                                ){

        return inters;

    }


   @PostMapping("/get1")
    public String get1(HttpServletRequest request){


       request.setAttribute("msg","重要信息");
        return "55555";
    }

    @ResponseBody
    @GetMapping("/success")
    public MSG get2(@RequestAttribute("msg") String msg,
                    HttpServletRequest request){

        String msg2=(String)request.getAttribute("msg");
        MSG mob=new MSG();
        mob.setM1(msg);
        mob.setM2(msg2);


      return mob;

    }


    @RequestMapping("/MSG")
    @ResponseBody
    public void getMSG(@RequestBody MSG msg) {


        System.out.println(msg);
        System.out.println(msg.getM1());
        System.out.println(msg.getM2());


    }

    @RequestMapping("/gt/{id1}/{id2}")

    public void gt( @MatrixVariable(value = "id",pathVar = "id2")  List<String > id){
        System.out.println(id);


    }


    @ResponseBody
    @RequestMapping("/MSG2")
    public void getMSG2(@RequestParam("msg") MSG msg){
        System.out.println(msg);


    }



    @RequestMapping("/MSG3")
    public String getMSG3(){


        int i=10/0;
        return "login";

    }


    @GetMapping("/jdbc")
    @ResponseBody
    public  void jtest(){


        String sql="select * from books;";

       // String name= template.queryForObject("select name from books where  id=1;",java.lang.String.class);
      //  List<Book> list=template.queryForList(sql,Book.class);
        // List<Book> list  = template.queryForList("select * from books;");
        //System.out.println(list);
        //List<Book> list=template.query()
        List list1 = new ArrayList();

      //  String sql = "select * from userinfo where id<? and username=?";

        list1 = (List) template.query(sql, new PreparedStatementSetter() {

            public void setValues(PreparedStatement ps) throws SQLException {

            }

        }, new ResultSetExtractor() {

            public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Book> list = new ArrayList<Book>();

                while (rs.next()) {

                    Book u = new Book();

                    u.setId(rs.getInt("id"));

                    u.setName(rs.getString("name"));

                    u.setPrice(rs.getFloat("price"));

                    u.setAuthor(rs.getString("author"));

                    list.add(u);

                }

                return list;
            }
        });

        System.out.println(list1.get(0));

    }




    @GetMapping("/mybatis")
    public String getBookById(@RequestParam( value="pn",defaultValue="1")int pn,Model model){



      //Book book= service.getBookById(id);
      // List<Book> list= service.list();
        Page <Book> bookPage=new Page<Book>(pn,2);

        Page<Book>  page=service.page(bookPage,null);

        System.out.println(page.getTotal());




       model.addAttribute("page",page);


      return  "show";

    }



    @GetMapping("/delete/{id}")
    public String deleteB(@PathVariable("id") int id,
                          @RequestParam( value = "pn",defaultValue = "1") int pn,
                          RedirectAttributes ra){

        service.removeById(id);
        ra.addAttribute("pn",pn);

        return "redirect:/mybatis";

    }






}
