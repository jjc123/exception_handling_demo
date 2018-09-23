package exception;

import java.io.IOException;

public class UserException extends Exception {
    //错误信息
    private String message;

    public UserException(String message) {
        super(message);
        this.message = message;
    }
    public String getMessage(){
        ExceptionPropertyUtil exceptionPropertyUtil = new ExceptionPropertyUtil();
        return exceptionPropertyUtil.getProperty(message);
    }
}
