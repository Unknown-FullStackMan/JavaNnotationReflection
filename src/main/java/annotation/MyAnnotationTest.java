package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Simple
 * @date 2021/4/25 9:58
 * 自定义注解类测试
 */
public class MyAnnotationTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("annotation.MyAnnotationUse");

        //获取类注解信息
        MyAnnotationDefinition classAnno = (MyAnnotationDefinition)clazz.getAnnotation(MyAnnotationDefinition.class);
        System.out.println(classAnno.name() + "----" + classAnno.value() + "----" + classAnno.path());

        //获取所有方法注解信息
        Method[] allmethods = clazz.getDeclaredMethods();
        for (int i = 0; i < allmethods.length; i++) {
            if(allmethods[i].isAnnotationPresent(MyAnnotationDefinition.class)){
                MyAnnotationDefinition myAnnotationDefinition = allmethods[i].getAnnotation(MyAnnotationDefinition.class);
                System.out.println("遍历：当前方法名为："+allmethods[i].getName()+"的注解信息:---"+myAnnotationDefinition.name()+"---"+myAnnotationDefinition.value()+"---"+myAnnotationDefinition.path());
            }
        }
    }
}
