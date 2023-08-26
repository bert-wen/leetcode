package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: leetcode
 * @package: test
 * @className: ThreadPrint
 * @author: WenHui
 * @description: TODO
 * @date: 2023/3/14 19:17
 * @version: 1.0
 */
//class printThread implements Runnable{
//    private static final Object LOCK = new Object();
//
//    private static int count = 0;
//    private LinkedList<Integer> queue;
//    private Integer threadNo;
//    public printThread(LinkedList<Integer> queue, Integer threadNo) {
//        this.queue = queue;
//        this.threadNo = threadNo;
//    }
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (LOCK) {
//                while (count % 3 != this.threadNo) {
//                    if (count >= 10) {
//                        break;
//                    }
//                    try {
//                        LOCK.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                if (count >= 10) {
//                    break;
//                }
//
//                Integer val = this.queue.poll();
//                System.out.println("thread-" + this.threadNo + ":" + val);
//                count++;
//
//                LOCK.notifyAll();
//            }
//        }
//    }
//}
public class ThreadPrint {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int m= scanner.nextInt();
        int n = scanner.nextInt();
        printNum(n,m);

    }


    public static void printNum(int n,int m) throws InterruptedException {
        LinkedList<Integer> queue= new LinkedList<>();
        for (int i=0;i<m;i++){
            queue.add(getNum(i+1));
        }
        final Semaphore[] semaphores = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            //非公平信号量，每个信号量初始计数都为1
            semaphores[i] = new Semaphore(1);
            if (i != n - 1) {
                System.out.println(i+"==="+semaphores[i].getQueueLength());
                //获取一个许可前线程将一直阻塞, for 循环之后只有 syncObjects[2] 没有被阻塞
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < n; i++) {
            // 初次执行，上一个信号量是 syncObjects[2]
            final Semaphore lastSemphore = i == 0 ? semaphores[n- 1] : semaphores[i - 1];
            final Semaphore currentSemphore = semaphores[i];
            new Thread(() -> {
                try {
                    while (true) {
                        // 初次执行，让第一个 for 循环没有阻塞的 syncObjects[2] 先获得令牌阻塞了
                        lastSemphore.acquire();
                        System.out.println(queue.poll());
                        // 释放当前的信号量，syncObjects[0] 信号量此时为 1，下次 for 循环中上一个信号量即为syncObjects[0]
                        currentSemphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

//        System.out.println(queue);

    }
    public static int getNum(int m){
        if (m==1){
            return 2347;
        }
        if(m==2){
            return 3917;
        }
        return (getNum(m-1)*getNum(m-1)+9337*getNum(m-2)+6047)%10000;
    }
}
