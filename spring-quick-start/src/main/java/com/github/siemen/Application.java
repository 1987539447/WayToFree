package com.github.siemen;

import com.github.siemen.component.MessagePrinter;
import com.github.siemen.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Zhan on 2017/2/13 0013.
 */
@Configuration
@ComponentScan
public class Application {
    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            public String getMessage() {
                return "Hello World";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}
