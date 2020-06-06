package top.kwind.rlfz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author xagu
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RlfzEntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RlfzEntranceApplication.class, args);
    }

}