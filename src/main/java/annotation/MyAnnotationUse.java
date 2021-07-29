package annotation;

import lombok.Data;

/**
 * @author Simple
 * @date 2021/4/25 9:53
 * 自定义注解类使用
 */
@MyAnnotationDefinition(name = "类名称",value = "类值",path = "类路径")
@Data
public class MyAnnotationUse {

    @MyAnnotationDefinition(name = "属性名",value = "属性值",path = "属性路径")
    private String name;
    @MyAnnotationDefinition(name="年龄",value="18",path="/user2")
    private String age;
    @MyAnnotationDefinition(name = "方法名1",value = "方法值1",path = "方法访问路径1")
    public String testAnno(){
        return "测试自定义注解作用在方法上！";
    }
    @MyAnnotationDefinition(name="方法名2",value="方法值2",path="方法访问路径2")
    public String getName() {
        return name;
    }
}
