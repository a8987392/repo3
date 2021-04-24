import boot.MainApplication;
import boot.myclasses.Pet;
import boot.service.Mapper001Service;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


@SpringBootTest(classes = MainApplication.class)
//@RunWith(SpringRunner.class)



public class tt  {

    @Autowired
    public Mapper001Service service;

    @Autowired
    private Pet p;

    private Stack<Integer> stack;
/*
    @Test
    public  void tte(){

        if(2==2){
            Assertions.fail();
        }
      // Assumptions.assumeTrue(false);
        System.out.println("1");
    }


    @Test
    public  void tte2(){

        System.out.println("2");

        Object ob1=new Object();
        Object ob2=new Object();


       // Assertions.assertSame(ob1,ob2,"该对象不是你期望的对象");

     //   Assertions.assertEquals(5,8,"不相等");

      //  System.out.println("tte2方法运行完毕");

        //  Assertions.assertArrayEquals(new int[]{1,2},new int[]{2,3},"期望的数组不相等");

      //  Assertions.assertAll("test",
        //        ()->Assertions.assertTrue(false,"条件1不满足"),
          //      ()->Assertions.assertFalse(false,"条件2不满足"));

      //  Assertions.assertThrows(ArithmeticException.class,()->{int i=10/1;},"并没有出现你想要的异常");


        if(2==2){
            Assertions.fail();

        }
    }
    */

    @ParameterizedTest

    @MethodSource("strt")
    public void aaa(String i){

        System.out.println(i);

    }


    public static Stream<String> strt(){

        return  Stream.of("aaa","bbb","ccc");

    }



    @Test
    public void abc(){

        p.setName("mon");
        System.out.println(p);
       // Assertions.assertNotNull(stack,"stack为null");
    }

    @BeforeEach
    public void abc3(){

        stack=new Stack<Integer>();

    }

    @Nested
    class inner{

        @Test
        public  void abc2(){
            Assertions.assertNotNull(stack,"stack为null");
        }






    }














}
