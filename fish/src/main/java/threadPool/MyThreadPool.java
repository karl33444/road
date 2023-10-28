package threadPool;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池demo
 * Executors四种创建线程池方式比较
 * @author yangf073
 * @date 2023/5/4 9:57
 */
public class MyThreadPool {
    public static void main(String[] args) {
        // fixedThreadPool();
        // Scanner sc = new Scanner(System.in);
        String rowId = "11";
        StringBuffer convert = new StringBuffer();
        // 判空
        // if (StringUtils.isEmpty(rowId)) {
        //     return null;
        // }
        // 去除开头的0
        for (int i = 0; i < rowId.length(); i++) {
            if (rowId.charAt(0) == '0') {
                rowId.substring(0);
            }
        }
        // 数字转换
        // for (int i = 0; i < rowId.length(); i++) {
            if (Integer.parseInt(rowId) >= 1 && Integer.parseInt(rowId) <= 26) {
                // System.out.print(rowOrColumnId.charAt(i)-'A'+1);
                convert.append((char)(Integer.valueOf(rowId) + 64));
            }
        rowId = convert.toString();
        System.out.println(rowId);
        // return Integer.parseInt(rowOrColumnId);

    }

    // newFixedThreadPool
    public static void fixedThreadPool (){
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            // 创建任务
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
                        System.out.println("当前执行的线程为：" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 任务添加到线程池
            threadPool.execute(runnable);
        }
    }
}
