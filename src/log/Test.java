package log;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by admin on 2017/1/18.
 */
public class Test{
    private static  final Logger LOGGER = LogManager.getLogger(Test.class.getName());
    public static void main(String[] args) {
        // 记录debug级别的信息
        LOGGER.debug("This is debug message.");
        // 记录info级别的信息
        LOGGER.info("This is info message.");
        // 记录warn级别的信息
        LOGGER.warn("This is warn message.");
        // 记录error级别的信息
        LOGGER.error("This is error message.");
    }
}
