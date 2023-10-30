package jcip.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author yangf073
 * @date 2023/10/30 23:24
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;
    public synchronized int getNext(){
        return value++;
    }

    public static void main(String[] args) {
        UnsafeSequence sequence = new UnsafeSequence();
        new Thread(()->{
            for (int i = 0;i < 10;i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"---->" + sequence.getNext());
            }
        }).start();

        new Thread(()->{
            for (int i = 0;i < 10;i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"---->" + sequence.getNext());
            }
        }).start();
    }
}
