package controller;

import exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/error")
    public String throwError(Model model) throws Exception {
        throw new UserException("user.not.have");        //输出：没有此人！
        //throw new UserException("xx");                 //输出：xx
        //throw new Exception();                         //输出：未知错误
    }
}
