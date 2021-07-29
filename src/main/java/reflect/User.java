package reflect;

import lombok.Data;

/**
 * @author Simple
 * @date 2021/4/25 10:18
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String age;

    public void hello(String h1,int h2){
        System.out.println(h1+"---"+h2);
    }
}
