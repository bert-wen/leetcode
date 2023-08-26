package test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @projectName: leetcode
 * @package: test.thread
 * @className: TestThreadPrint
 * @author: WenHui
 * @description: 多个线程交替打印
 * @date: 2023/3/15 8:49
 * @version: 1.0
 */
public class TestThreadPrint {
    private static Object object=new Object();
    private static int threadIndex = 0;
    private static volatile int count = 0;
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3,4,5,6,7,8,9,10).collect(Collectors.toList());
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++){
            new Thread(new MyThread(i,n,collect)).start();
        }
    }
   static class MyThread implements Runnable{
        private int thread;
        private int threadCount;
        private List<Integer> list;
        MyThread(int thread,int count,List<Integer> list){
            this.thread= thread;
            this.threadCount=count;
            this.list=list;
        }
        @Override
        public void run() {
            while (count < list.size()-1){
                if (threadIndex %  threadCount == thread){
                    synchronized (object){
                        threadIndex ++;
                        System.out.println(Thread.currentThread().getName() + ":" + list.get(count));
                        count ++;
                    }
                }
            }
        }

    }
}
