package data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectApplication {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("elasticsearch");
        logger.info("Hello, aspects!");

        SpringApplication.run(AspectApplication.class, args);
    }
}
