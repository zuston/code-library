package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zuston on 16-11-7.
 */
public class params {
    public static void main(String[] args) {
        params.f(34,456,56,57);
        System.out.println(params.t(234,35,45,45));

        System.out.println("================");

        exe ex = new exe();
        ex.addList();
        Iterator<Integer> it = ex.iterator();
        while (it.hasNext()){
            System.out.println("每一个:"+it.next());
        }

        System.out.println("================");
    }

    public static <T> void f(T... values){
        for (T value:values){
            System.out.println(value);
        }
    }

    public static <T> List<T> t(T... values){
        List<T> list = new ArrayList<T>();
        for (T value:values){
            list.add(value);
        }
        return list;
    }
}


class exe implements Iterable<Integer>{
    public exe(){

    }
    public List<Integer> list = new ArrayList<Integer>();
    public void addList(){
        for (int i=0;i<10;i++){
            list.add(i);
        }
        count = list.size()-1;
    }
    public int count = 0;

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return count>0?true:false;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Integer next() {
                count--;
                return list.get(count);
            }
        };
    }
}

class pexe extends exe{

}
