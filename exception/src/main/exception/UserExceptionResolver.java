package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserExceptionResolver implements HandlerExceptionResolver {

    UserException userException = null;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof UserException){
            userException = (UserException)ex;
        }else{
            userException = new UserException("未知错误");
        }

        String message = userException.getMessage();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message",message);
        modelAndView.setViewName("/errorContext");

        return modelAndView;
    }
}
