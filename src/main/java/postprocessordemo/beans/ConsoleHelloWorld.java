package postprocessordemo.beans;

import postprocessordemo.annotations.AutoFillStringValue;
import postprocessordemo.annotations.AutoFillStringValueType;
import postprocessordemo.annotations.Timed;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log4j2
@Timed
public class ConsoleHelloWorld implements HelloWorld {

    @Getter @Setter
    private String welcomeString;

    @Getter
    @AutoFillStringValue(type = AutoFillStringValueType.UUID)
    private String id;

    public ConsoleHelloWorld() {
        log.info("Constructor was invoked");
    }

    @PostConstruct
    public void init() {
        log.info("PostConstract method was invoked");
    }

    @PreDestroy
    public void destroy() {
        log.info("PreDestroy method was invoked");
    }

    @Override
    public void sayHello() {
        System.out.println(welcomeString + ", id= " + id);
    }
}
