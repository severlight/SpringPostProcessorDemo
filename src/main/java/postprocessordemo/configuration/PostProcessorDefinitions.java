package postprocessordemo.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import postprocessordemo.postprocessors.LogBeanPostProcessor;
import postprocessordemo.postprocessors.GenerateUuidPrimaryAutoFillAnnotatedAnnotatedFieldPostProcessor;
import postprocessordemo.postprocessors.TimedAnnotationBeanPostProcessor;

@Log4j2
@Configuration
public class PostProcessorDefinitions {

    @Bean
    public static LogBeanPostProcessor logInitializationBeanPostProcessor() {
        return new LogBeanPostProcessor();
    }

    @Bean
    public static GenerateUuidPrimaryAutoFillAnnotatedAnnotatedFieldPostProcessor logMethodInvokeBeanPostProcessor() {
        return new GenerateUuidPrimaryAutoFillAnnotatedAnnotatedFieldPostProcessor();
    }

    @Bean
    public static TimedAnnotationBeanPostProcessor timedAnnotationBeanPostProcessor() throws Exception {
        return new TimedAnnotationBeanPostProcessor();
    }
}
