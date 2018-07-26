package postprocessordemo.postprocessors;

import postprocessordemo.annotations.AutoFillStringValue;
import postprocessordemo.annotations.AutoFillStringValueType;

import java.lang.reflect.Field;
import java.util.UUID;


public class GenerateUuidPrimaryAutoFillAnnotatedAnnotatedFieldPostProcessor extends AbstractPopulateAnnotatedFieldPostProcessor<AutoFillStringValue> {

    @Override
    String generateValue(AutoFillStringValue annotation) {
        if(annotation.type() == AutoFillStringValueType.UUID) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

    @Override
    AutoFillStringValue getFieldAnnotation(Field field) {
        return field.getAnnotation(AutoFillStringValue.class);
    }
}
