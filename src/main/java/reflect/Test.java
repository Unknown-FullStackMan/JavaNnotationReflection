package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Simple
 * @date 2021/4/25 10:18
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //通过反射返回类的Class对象，这里的Class就是Object类中的getClass()方法的返回值Class是一样的，获取的clazz就是获取的Claas类
        Class clazz = Class.forName("reflect.User");
        System.out.println(clazz);

        //一个类在方法区中只有一个Class对象
        //一个类被加载之后，类的整个结构(构造器、方法、属性等)都会被封装到Claas对象中
        Class clazz2 = Class.forName("reflect.User");
        System.out.println(clazz.hashCode());
        System.out.println(clazz2.hashCode()==clazz.hashCode());



        //获取类的实例的方法

        //通过类的class属性获取，该方法最为安全可靠，程序性能最高
        Class c1 = User.class;
        User user = (User)c1.newInstance();
        //通过类的实例中的getClass()方法获取
        Class c2 = c1.getClass();
        //通过类的全限定类名获取
        Class c3 = Class.forName("reflect.User");
        //通过基本内置类型的包装类的Type属性（了解）
        Class c4 = Integer.TYPE;
        //通过ClassLoader类加载器获取
        ClassLoader  classLoader = Test.class.getClassLoader();
        Class c5 = classLoader.loadClass("reflect.User");
        System.out.println(classLoader);
        System.out.println(c1 == c5);




        //获取User的实例化对象方法

        //class的newInstance方法：本质会直接调用该类的无参构造函数进行实例化
        //jdk1.9开始该方法被抛弃，使用getDeclaredConstructor()方法
        // getDeclaredConstructor()方法会根据他的参数对该类的构造函数进行搜索并返回对应的构造函数，没有参数就返回该类的无参构造函数，然后再通过newInstance进行实例化。
        User user1 = User.class.newInstance();
        user1.setAge("1");
        System.out.println(user1);

        //构造器的newInstance方法
        Constructor constructor = User.class.getDeclaredConstructor();
        User user2 = (User) constructor.newInstance();
        user2.setAge("2");
        System.out.println(user2);
        //System.out.println(user1.getClass() == user2.getClass());

        //通过反射调用普通方法
        Method method = c1.getDeclaredMethod("hello",String.class,int.class);
        method.invoke(user2,"1111",1);






        Field age = c1.getDeclaredField("age");
        age.setAccessible(true);
        age.set(user2,"99");
        System.out.println(user2.getAge());

    }
}
