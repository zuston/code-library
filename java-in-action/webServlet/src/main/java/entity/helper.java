package entity;

/**
 * Created by zuston on 16-11-10.
 */
public class helper {

    private static helper hp = null;
    public static helper getInstance(){
        if(hp==null){
            System.out.println("生成helper对象");
            hp = new helper();
        }
        return hp;
    }
}
