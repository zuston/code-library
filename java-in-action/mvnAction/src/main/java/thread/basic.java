package thread;

/**
 * Created by zuston on 16-11-9.
 */
public class basic {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(i);
                }
            }
        });
        thread.start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("线程操作");
            }
        }).start();
    }
}
