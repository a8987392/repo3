package configs;

import boot.myclasses.MSG;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MyConvert implements Converter<String, MSG> {
    @Override
    public MSG  convert(String source){
        if(!source.equals("")){
            MSG msg=new MSG();
            String []split=source.split(",");
            msg.setM1(split[0]);
            msg.setM2(split[1]);

            System.out.println(6666);
            return msg;

        }
        System.out.println(6666);
        return null;
    }


}
