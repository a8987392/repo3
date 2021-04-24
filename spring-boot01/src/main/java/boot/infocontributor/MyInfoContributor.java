package boot.infocontributor;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class MyInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("myname","tcc").
                withDetail("myage",26).
                withDetails(Collections.singletonMap("mymap","mapele1"));


    }
}
