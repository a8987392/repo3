package boot.service;

import boot.mapperIn.Mapper001;
import boot.myclasses.Book;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;


@Service
public class Mapper001ServiceImpl extends ServiceImpl<Mapper001, Book> implements  Mapper001Service {


    Counter counter;


    public Mapper001ServiceImpl(MeterRegistry meterRegistry){

      counter= meterRegistry.counter("counttest");


    }


    public void counttest(){
        counter.increment();

    }






}
