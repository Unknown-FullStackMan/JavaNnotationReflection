package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Simple
 * @date 2021/4/25 9:48
 * 自定义注解类声明
 */
@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface  MyAnnotationDefinition {
    //定义注解里面的参数信息
    String name();

    String value();

    String path();
}
