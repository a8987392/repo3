package configs.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requesturi=request.getRequestURI();
       // System.out.println(requesturi);

        HttpSession session=request.getSession();

        if(session.getAttribute("user")!=null){

            return true;

        }else{


            response.sendRedirect("/world/login");
            return false;

        }

    }



}
