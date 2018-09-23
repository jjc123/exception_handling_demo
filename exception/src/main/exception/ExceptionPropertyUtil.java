package exception;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExceptionPropertyUtil {
    private static Properties props;
    static
    {
        loadProps();
    }

    synchronized static private void loadProps()
    {
        props = new Properties();
        InputStream in = null;
        try
        {
            // 第一种通过类加载器进行获取properties文件流
            //in = ExceptionPropertyUtil.class.getClassLoader().getResourceAsStream("exceptionMapping.properties");
            // 第二种，通过类进行获取properties文件流
             in = ExceptionPropertyUtil.class.getResourceAsStream("/exceptionMapping.properties");
            props.load(in);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        finally
        {
            try
            {
                if (null != in)
                {
                    in.close();
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException("properties文件流关闭出现异常");
            }
        }
    }
    public static String getProperty(String key)
    {
        if (null == props)
        {
            loadProps();
        }
        String message = props.getProperty(key);
        if(message==null){
            return key;
        }else{
            return message;
        }
    }
}