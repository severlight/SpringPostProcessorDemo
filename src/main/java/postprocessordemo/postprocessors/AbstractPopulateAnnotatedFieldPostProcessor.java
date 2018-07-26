package postprocessordemo.postprocessors;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public abstract class AbstractPopulateAnnotatedFieldPostProcessor<T extends Annotation> implements BeanPostProcessor {

    abstract String generateValue(T annotation);

    abstract T getFieldAnnotation(Field field);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for(Field field : declaredFields) {
            T annotation = getFieldAnnotation(field);
            if(annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, generateValue(annotation));
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
