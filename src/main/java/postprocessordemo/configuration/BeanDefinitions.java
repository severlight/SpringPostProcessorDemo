package postprocessordemo.configuration;

import postprocessordemo.beans.ConsoleHelloWorld;
import postprocessordemo.beans.HelloWorld;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class BeanDefinitions {

    @Bean
    public HelloWorld helloWorld() {
        log.info("Create object ConsoleHelloWorld");
        ConsoleHelloWorld consoleHelloWorld = new ConsoleHelloWorld();
        consoleHelloWorld.setWelcomeString("Hello injected string");
        return consoleHelloWorld;
    }
}
