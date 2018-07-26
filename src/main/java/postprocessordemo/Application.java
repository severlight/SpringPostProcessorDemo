package postprocessordemo;

import postprocessordemo.beans.HelloWorld;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import postprocessordemo.configuration.BeanDefinitions;
import postprocessordemo.configuration.PostProcessorDefinitions;

@Log4j2
@SpringBootApplication
public class Application {

    public static void main(String... args) {

        ConfigurableApplicationContext ctx = new SpringApplication(BeanDefinitions.class, PostProcessorDefinitions.class).run(args);
        log.info("Application started");
        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.sayHello();
        ctx.close();
    }
}
